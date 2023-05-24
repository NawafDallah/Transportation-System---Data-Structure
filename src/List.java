//
//NAWAF MUSTAFA DALLAH_441106022
//

public interface List<T>{
	
	
	public boolean empty();
	public boolean full();
	public void findFirst();
	public void findNext();
	public boolean last();
	public T retrieve();
	public void update(T e);
	public void insert(T e);
	public void remove();
}