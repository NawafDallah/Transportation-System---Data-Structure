//
//NAWAF MUSTAFA DALLAH_441106022
//
public class ListNode<T> {

	//Attributes
	private T data;
    private ListNode<T> next;
	
    
    
    //Constructors
    public ListNode() 
    {
      	data = null;
      	next = null;
    }
    public ListNode(T e) 
    {
      	data = e;
      	next = null;
    }


    
   // Setters/Getters
    
    
	public T getData()
	{
		return data;
	}

	public void setData(T data) 
	{
		this.data = data;
	}

	public ListNode<T> getNext() 
	{
		return next;
	}

	public void setNext(ListNode<T> next) 
	{
		this.next = next;
	}   
}