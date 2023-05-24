//
//NAWAF MUSTAFA DALLAH_441106022
//

// Stores a pair of elements .
public class Pair<U,V>{

	//Attributes
	public U first;
	public V second;

	
	
	//Constructor
	public Pair(U first, V second) 
	{
		this.first = first ;
		this.second = second ;
    }

	
	
	
	@Override
	public String toString()
	{
		return "(" + first + "," + second + ")";
	}
}