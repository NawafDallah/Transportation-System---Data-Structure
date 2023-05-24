//
//NAWAF MUSTAFA DALLAH
//
public class LocNode<T> {

	
	//Attributes
	private Location key;
	private List<T> data = new LinkedList<T>();
	private LocNode<T> Child1 , Child2, Child3 , Child4;
	
	
	//Constructor
	public LocNode(T e, Location key) 
	{
		this.key = key;
		data.insert(e);
		Child1 = Child2 = Child3 = Child4 = null;
	}
	public LocNode() 
	{
		this.key = null;
		data.insert(null);
		Child1 = Child2 = Child3 = Child4 = null;
	}


	
	//Setters/Getters

	
	
	public Location getKey() {
		return key;
	}
	public void setKey(Location key) {
		this.key = key;
	}



	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}



	public LocNode<T> getChild1() {
		return Child1;
	}
	public void setChild1(LocNode<T> child1) {
		Child1 = child1;
	}
	
	
	
	
	public LocNode<T> getChild2() {
		return Child2;
	}
	public void setChild2(LocNode<T> child2) {
		Child2 = child2;
	}



	public LocNode<T> getChild3() {
		return Child3;
	}
	public void setChild3(LocNode<T> child3) {
		Child3 = child3;
	}



	public LocNode<T> getChild4() {
		return Child4;
	}
	public void setChild4(LocNode<T> child4) {
		Child4 = child4;
	}
	
	
	
	
	
	//Some Methods to help
	 
    
	
     
     public boolean searchData(T e)
     {
         // searching data from data list
         if(data.empty())
        	 return false;
             data.findFirst();
             while(!data.last())
             {
                 if(data.retrieve().equals(e))
                     return true;
                 this.data.findNext();
             }
             if(data.retrieve().equals(e))
                 return true;
         return false;
     }
     
     
     
     
     public int lengthData()
 	{ 
    	 // counting data from data list
 		if(data.empty())
 			return 0;
 		int count = 0;
 		this.data.findFirst();
 		while(!data.last()) 
 		{
 			count++;
 			data.findNext();
 		}
 		count++;
 		return count;
 	}
}