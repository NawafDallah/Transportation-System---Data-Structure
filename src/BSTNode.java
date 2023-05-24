//
//NAWAF MUSTAFA DALLAH 441106022
//
public class BSTNode<K extends Comparable<K>, T>{

	
	//Attributes
	private K key;
	private T data;
	private BSTNode<K,T> left,right;
	
	
	
	
	//Constructors
	public BSTNode() 
	{
		this.key = null;
		data = null;
		left = right = null;
	}
	public BSTNode(K key, T e) 
	{
		this.key = key;
		data = e;
		left = right = null;
	}
	public BSTNode(K key, T e, BSTNode<K,T> l, BSTNode<K,T> r) 
	{
		this.key = key;
		data= e;
		left = l;
		right = r;
	}
	
	
	
	//Setters/Getters
	
	
	
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	
	
	public T getData() {
		return data;
	}
	public void setDAta(T e) {
		data = e;
	}
	
	
	public BSTNode<K, T> getLeft() {
		return left;
	}
	public void setLeft(BSTNode<K, T> left) {
		this.left = left;
	}
	
	
	public BSTNode<K, T> getRight() {
		return right;
	}
	public void setRight(BSTNode<K, T> right) {
		this.right = right;
	} 	
}