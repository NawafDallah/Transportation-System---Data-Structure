//
//NAWAF MUSTAFA DALLAH_441106022
//
public class LinkedList<T> implements List<T> {

	//Attributes
	private ListNode<T> head, current;
	
	
	//Constructor
	public LinkedList() 
	{
		current = head = null;
	}
	
	
	
	//Methods
	
	
	   public boolean empty() 
	   {
		   return head == null;
	   }
	   
	   
	   public boolean full() 
	   {
		   return false;
	   }
	   
	   
	   
	   public void findFirst() 
	   {
		   current = head;
	   }
	   
	 
	   public void findNext() 
	   {
		   current = current.getNext();
	   }
	   
	   
	   public boolean last()
	   {
		  return current.getNext() == null;
	   }
	   
	  
	   public T retrieve() 
	   {
		   return current.getData();
	   }
	   
	   
	   public void update(T e) 
	   {
		current.setData(e);
	   }
	
	
	
	   
	   public void insert(T e) 
	   {
		   ListNode<T> newnode = new ListNode<T>(e);
		   if(empty())
			   head = current = newnode;
		   else 
		   {
			 newnode.setNext(current.getNext());
			 current.setNext(newnode);  
			 current = newnode;
		   }
	   }
	   
	   
	   public void remove() 
	   {
		   if(current == head) 
			   head = head.getNext();
		   else 
		   {
			 ListNode<T> temp = head;
			 while(temp.getNext() != current)
				 temp = temp.getNext();
			 temp.setNext(current.getNext());
	       }
		   if(current.getNext() == null)
			   current = head;
		   else
			   current = current.getNext();
	   }
}