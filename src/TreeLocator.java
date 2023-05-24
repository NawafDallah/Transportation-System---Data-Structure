//
//NAWAF MUSTAFA DALLAH 441106022
//
public class TreeLocator<T> implements Locator<T> {
	
	//Attributes
	LocNode<T> root, current;
	
	
	//Constructor
	public TreeLocator() 
	{
		root = current = null;
	}
	
	
	
	
	
	// Makes the element with Location key the current element if it exists, and if key does
    // not exist, current is pointing to parent of the new key, The first element of the returned pair
    // indicates whether key exists, and the second is the number of key comparisons
    // made. 
	private Pair < Boolean , Integer > findLoc(Location key)
    {
        boolean found = false;
        int comparisons = 0 ; 
        
        if (root == null)
        	return new Pair<Boolean, Integer>(found, comparisons);
        
            LocNode<T> p = root,q = null;
            while(p != null) 
            {
                    q = p;
                    
                    comparisons ++;
                    if ((p.getKey().x == key.x ) && (p.getKey().y == key.y) )
                    {
                        current = p;
                        found = true;
                        break;
                    }
                         if (( key.x  < p.getKey().x ) && ( key.y <= p.getKey().y ))
                            p = p.getChild1();
                    else if (( key.x  <= p.getKey().x ) && ( key.y > p.getKey().y ))
                            p = p.getChild2();
                    else if (( key.x  > p.getKey().x ) && ( key.y >= p.getKey().y ))
                            p = p.getChild3();
                    else if (( key.x  >= p.getKey().x ) && ( key.y < p.getKey().y ))
                            p = p.getChild4();
            }
            current = q;
        
        return (new Pair < Boolean , Integer >(found,  comparisons));
    }
  	
  	
  	
  	
  	
  	
	// Inserts e at location loc and returns the number of comparisons made when
    // searching for loc.
      public int add(T e, Location loc) 
      {
    	  LocNode<T> newnode = new LocNode<T>(e,loc);
    	  LocNode<T> q = current;
  		
  		Pair<Boolean, Integer> pair = findLoc(loc);
  		if(pair.first) // if true that means location is already exist
  		{
  	        current.getData().insert(e);
  			return pair.second;
  		}
  		if(root == null) //empty tree
  		{
  			root = current = newnode;	
  			return pair.second;
  		}
  		else //current is pointing to parent of the new key
  		{
  			if((loc.x < current.getKey().x ) && (loc.y <= current.getKey().y ))
  				current.setChild1(newnode);
  			else if((loc.x <= current.getKey().x ) && (loc.y > current.getKey().y))
  				current.setChild2(newnode);
  			else if((loc.x > current.getKey().x ) && (loc.y >= current.getKey().y))
  				current.setChild3(newnode);
  			else if((loc.x >= current.getKey().x ) && (loc.y < current.getKey().y))
  			current.setChild4(newnode);
  			current = newnode;
  		}
  		return pair.second;  
      }
	
	
	
	
      
    // The first element of the returned pair is a list containing all elements
  	// located at loc. If loc does not exist or has no elements, the returned list
  	// is empty. The second element of the pair is the number of comparisons made
  	// when searching for loc.
  	public Pair<List<T>, Integer> get(Location loc)
  	{
  		LocNode<T> q = current;
  		List<T> cars = new LinkedList<T>();
  		Pair<Boolean, Integer> pair = findLoc(loc);
  		
  		if(pair.first) 
  		{
  			if(current.getData().empty())// loc has no elements
  				return new Pair<List<T>, Integer>(cars, pair.second);//returned empty list with number of comparisons
  			else // loc has elements
  			{
  				current.getData().findFirst();
  				while(!current.getData().last()) 
  				{
  					cars.insert(current.getData().retrieve());
  					current.getData().findNext();
  				}
  				cars.insert(current.getData().retrieve());
  				return new Pair<List<T>, Integer>(cars, pair.second);
  			}
  		}
  		else //we don't fine Location
  		{
  		current = q;
  		return new Pair<List<T>, Integer>(cars, pair.second); // empty list with number of comparisons
  		}
  	}
	
	
	
      
  	
  	
    // Removes all occurrences of element e from location loc . The first element
 	// of the returned pair is true if e is removed and false if loc does not exist
 	// or e does not exist in loc . The second element of the pair is the number of
 	// comparisons made when searching for loc .
  	public Pair<Boolean, Integer> remove(T e, Location loc) 
    {
        LocNode<T>  curr = current;
        boolean found = false;
        
        Pair < Boolean , Integer > pair = findLoc (loc);
        
        // there are cars in this location
        if (pair.first == true)
        {
            if (! current.getData().empty())
            {
                current.getData().findFirst();
                while (!current.getData().last())
                {
                    if (e.equals(current.getData().retrieve()))
                    {
                        current.getData().remove();
                        found = true;
                    }
                    else
                        current.getData().findNext();
                }
                if (e.equals(current.getData().retrieve()))
                {
                    current.getData().remove();
                    found = true;
                }
            }
        }
        else
            current = curr;
         
        return ( new Pair<> (found, pair.second));
    }
	
	
 	
 	
 	
    // Returns all locations and the elements they contain .
 	public List <Pair<Location, List<T>>> getAll() 
 	{
 		List<Pair<Location, List<T>>> L = new LinkedList<Pair<Location, List<T>>>();
        if(root!= null)getAll(root, L); 
        return L;	
 	}
     // recursive function parent and then all children
 	private void  getAll(LocNode<T> p, List <Pair<Location, List<T>>> list)
 	{
 		if (p == null)
 			return;
 		else 
 		{
 			List<T> cars = new LinkedList<T>();
 			if (!p.getData().empty())
            {               
 			p.getData().findFirst();
            while (!p.getData().last())
            {
           	cars.insert(p.getData().retrieve());
               p.getData().findNext();
            }
            cars.insert(p.getData().retrieve());
            }
 			Pair<Location, List<T>> pair = new Pair<Location, List<T>>(p.getKey(), cars);
 			list.insert(pair);
 			
 			getAll( p.getChild1(), list) ;
 	        getAll( p.getChild2(), list) ;
 	        getAll( p.getChild3(), list) ;
 	        getAll( p.getChild4(), list) ;
 		}
 	}
 	
 	
 	
 	
 	
 	
 	
    // The first element of the returned pair is a list of all locations and their
 	// data if they are located within the rectangle specified by its lower left and
 	// upper right corners ( inclusive of the boundaries ). The second element of the
 	// pair is the number of comparisons made .
 	public Pair <List<Pair<Location, List<T>>>,Integer> inRange(Location lowerLeft, Location upperRight)
 	{
 		int num =0;
        Location upperLeft = new Location (upperRight.x, lowerLeft.y);
        Location lowerRight = new Location (lowerLeft.x, upperRight.y);

        List<Pair<Location, List<T>>> list = new LinkedList<Pair<Location, List<T>>>();
     
         num = inRange(list, root, lowerLeft, upperRight , upperLeft, lowerRight);
         return new Pair <> (list, num);
         
    }
    private int inRange(List<Pair<Location, List<T>>> L ,  LocNode<T> p , Location lowerLeft, Location upperRight
                        , Location upperLeft, Location lowerRight)
    {
        if (p==null)
            return  0;
        else
        {
            int num = 1;
            if ((lowerLeft.x <= p.getKey().x && p.getKey().x <= upperRight.x) && (lowerLeft.y <= p.getKey().y  && p.getKey().y <= upperRight.y))
            {
                List<T> Ll = new LinkedList <T> ();
                
                if (!p.getData().empty())
                {
                    p.getData().findFirst();
                    while (!p.getData().last())
                    {
                        Ll.insert(p.getData().retrieve());
                        p.getData().findNext();
                    }
                    Ll.insert(p.getData().retrieve());
                    
                }   
                L.insert(new Pair<>(p.getKey(), Ll));
            }
            
            // current is pointing to parent of the new key
                  if ((( lowerLeft.x  < p.getKey().x ) && ( lowerLeft.y <= p.getKey().y )) 
                   || (( upperRight.x  < p.getKey().x ) && ( upperRight.y <= p.getKey().y )) 
                   || (( upperLeft.x  < p.getKey().x ) && ( upperLeft.y <= p.getKey().y )) 
                   || (( lowerRight.x  < p.getKey().x ) && ( lowerRight.y <= p.getKey().y )))
                num +=  inRange(L, p.getChild1(), lowerLeft, upperRight, upperLeft, lowerRight);
           
                   if((( lowerLeft.x  <= p.getKey().x ) && ( lowerLeft.y > p.getKey().y )) 
                   || (( upperRight.x  <= p.getKey().x ) && ( upperRight.y > p.getKey().y ))
                   || (( upperLeft.x  <= p.getKey().x ) && ( upperLeft.y > p.getKey().y )) 
                   || (( lowerRight.x  <= p.getKey().x ) && ( lowerRight.y > p.getKey().y )))
                num +=  inRange(L, p.getChild2() , lowerLeft, upperRight, upperLeft, lowerRight);
           
                   if ((( lowerLeft.x  > p.getKey().x ) && ( lowerLeft.y >= p.getKey().y )) 
                    || (( upperRight.x  > p.getKey().x ) && ( upperRight.y >= p.getKey().y ))
                    || (( upperLeft.x  > p.getKey().x ) && ( upperLeft.y >= p.getKey().y )) 
                    || ((lowerRight.x  > p.getKey().x ) && (lowerRight.y >= p.getKey().y )))
                num +=  inRange(L, p.getChild3() , lowerLeft, upperRight, upperLeft, lowerRight);
          
                   if ((( lowerLeft.x  >= p.getKey().x ) && ( lowerLeft.y < p.getKey().y )) 
                    || (( upperRight.x  >= p.getKey().x ) && ( upperRight.y < p.getKey().y ))
                    || (( upperLeft.x  >= p.getKey().x ) && ( upperLeft.y < p.getKey().y )) 
                    || (( lowerRight.x  >= p.getKey().x ) && ( lowerRight.y < p.getKey().y )))
                num += inRange(L, p.getChild4() , lowerLeft, upperRight, upperLeft, lowerRight);
            
            return num;
        }
 	}
}