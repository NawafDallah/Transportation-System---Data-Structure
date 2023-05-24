//
//NAWAF MUSTAFA DALLAH 441106022
//
public interface Map<K extends Comparable <K>,T>{

	
	
	//Returns true if the tree is empty. Must be O(1).
	boolean empty();
	//Returns true if the tree is full. Must be O(1).
	boolean full();
	//Returns the data of the current element
	T retrieve();
	//Updates the data of current element.
	void update(T e);
	
	
	//Makes the element with key k the current element if it exists, and if k does
	//not exist, the current is unchanged. The first element of the returned pair
	//indicates whether k exists, and the second is the number of key comparisons
	//made.
	Pair<Boolean , Integer>find(K key);

	
	//Inserts a new element if it does not exist and makes it the current element.
	//If the k already exists, the current does not change. The first element of
	//the returned pair indicates whether k was inserted, and the second is the
	//number of key comparisons made.
	Pair<Boolean, Integer>insert(K key, T data);

	
	//Removes the element with key k if it exists. The position of current is
	//unspecified after calling this method. The first element of the returned pair
	//indicates whether k was removed, and the second is the number of key
	//comparisons made.
	Pair<Boolean, Integer>remove(K key);

	
	//Returns all keys of the map as a list sorted in increasing order.
	List<K>getAll();
}