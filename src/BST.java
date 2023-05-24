//
//NAWAF MUSTAFA DALLAH 441106022
//
public class BST<K extends Comparable<K>,T> implements Map<K,T> {

	//Attributes
	private BSTNode<K,T> current, root;
	private BSTNode<K,T> current2;
	
	
	
	
	//Constructor
	public BST() 
	{
		root = current = null;
	}
	
	
	//Methodes
	
	//Returns true if the tree is empty. Must be O(1).
	public boolean empty() 
	{
		return root == null;
	}
	//Returns true if the tree is full. Must be O(1).
	public boolean full() 
	{
		return false;
	}
	//Returns the data of the current element
	public T retrieve() 
	{
		return current.getData();
	}
	//Updates the data of current element.
	public void update(T e) 
	{
		current.setDAta(e);
	}
	
	
	
	
	
	
	
	
	// Makes the element with key k the current element if it exists, and if k does
    // not exist, the current is unchanged. The first element of the returned pair
    // indicates whether k exists, and the second is the number of key comparisons
    // made.
	public Pair<Boolean, Integer> find(K key) 
	{
		if(!empty());
		return find(key, root, 0, false);
	}
	private Pair<Boolean, Integer> find(K key, BSTNode<K,T> p, int comparisons, boolean found) 
	{
		if(p == null)
			return new Pair<Boolean, Integer>(found, comparisons);
		 comparisons++;
		if(p.getKey().equals(key)) 
		{
			current2 = p;
			current = p;
			found = true;
			return new Pair<Boolean, Integer>(found, comparisons);
		}
		current2 = p;
		if(key.compareTo(p.getKey()) > 0)return find(key , p.getRight(), comparisons, found);
		return find(key, p.getLeft(), comparisons, found);
	}
	
	

	
	
	
	
	// Inserts a new element if it does not exist and makes it the current element.
    // If the k already exists, the current does not change. The first element of
    // the returned pair indicates whether k was inserted, and the second is the
    // number of key comparisons made.
	public Pair<Boolean, Integer>insert(K key, T data) 
	{
		BSTNode<K,T> newnode = new BSTNode<K,T>(key,data);
		BSTNode<K,T> q = current;
		
		Pair<Boolean, Integer> pair = find(key);
		if(pair.first) // if true that means k is already exist
		{
			current = q; // to keep current does not change
			//(first) The first element of the returned pair indicates whether k was inserted
			pair.first = false;// that mean no insert
			return new Pair<Boolean, Integer>(pair.first,pair.second);
		}
		if(empty()) 
		{
			root = current = current2 = newnode;
			pair.first = true;// that means k  inserted	
			return new Pair<Boolean, Integer>(pair.first,pair.second);
		}
		else // current2 is pointing to parent of the new key
		{
			if(key.compareTo(current2.getKey()) > 0)
				current2.setRight(newnode);
			else
				current2.setLeft(newnode);
			current = current2 = newnode;
			pair.first = true;// that means k  inserted
		}
		return new Pair<Boolean, Integer>(pair.first, pair.second);
	}
	
	
	
	
	
	// Removes the element with key k if it exists . The position of current is
    // unspecified after calling this method . The first element of the returned pair
    // indicates whether k was removed , and the second is the number of key
    // comparisons made .
    public Pair<Boolean , Integer> remove(K key)
    {
        BSTNode<K,T>  c = current;
        Pair <Boolean , Integer> pair = find (key);
        
        
        if (pair.first)  
        {
            K k1 = key;
            BSTNode<K,T> p = root;
            BSTNode<K,T> q = null;//Parent of p
            
            
            while (p != null) 
            {
                    if (k1.compareTo(p.getKey()) < 0) 
                    {
                        q = p;
                        p = p.getLeft();
                    } 
                    else if (k1.compareTo(p.getKey()) > 0) 
                    {    
                        q = p;
                        p = p.getRight();
                    }
                    else //here we found the key and now check 3 cases
                    { 
                        if ((p.getLeft() != null) && (p.getRight() != null)) // Case 3: two children
                        {  // Search for the min in the right subtree
                            BSTNode<K,T> min = p.getRight();
                            q = p;
                            while (min.getLeft() != null) 
                            {
                                q = min;
                                min = min.getLeft();
                            }
                            p.setKey(min.getKey()); 
                            p.setDAta(min.getData());
                            k1 = min.getKey();
                            p = min;
                        } //Now fall back to either case 1 or 2
                        //The subtree rooted at p will change here
                        if (p.getLeft() != null) // One child
                        { 
                            
                            p = p.getLeft();
                        } 
                        else // One or no children
                        { 
                            p = p.getRight();
                        }
                        if(q == null)// No parent for p, root must change
                        { 
                            root = p;
                        } 
                        else 
                        {
                            if (k1.compareTo(q.getKey()) < 0) 
                                q.setLeft(p); 
                            else 
                                q.setRight(p);
                        }
                    current = root;
                } 
            } //end while (p != null) 
            
                   
            //(first) The first element of the returned pair indicates whether k was removed
            pair.first = true; //that means remove successful
        }
        else //If the k not exists , the current does not change
        {
             
            //(first) The first element of the returned pair indicates whether k was removed
            current = c; // current does not change
            pair.first = false;// that means k is not exist
        }
        return new Pair<Boolean, Integer>(pair.first, pair.second);
    }
	
	
	
  //Returns all keys of the map as a list sorted in increasing order.
    public List<K> getAll()
    {
        List<K> L = new LinkedList<K>();
        getAll (root, L); 
        return L;
    }
    private void getAll(BSTNode<K,T> p, List<K> list) 
    {
        if(p == null)
            return;
        else
        {
            getAll(p.getLeft(), list); 
            list.insert(p.getKey());
            getAll(p.getRight(), list); 
        }
    }	
}