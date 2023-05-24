//
//NAWAF MUSTAFA DALLAH_441106022
//

// Represents a 2D location .
public class Location{

	//Attributes
	public int x;
	public int y;
	
	
	//Constructor
    public Location(int x, int y) 
    {
    	this.x = x;
    	this.y = y;
    }

    
    
    @Override
    public String toString()
    {
    	return "(" + x + "," + y + ")";
    }
}