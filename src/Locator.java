//
//NAWAF MUSTAFA DALLAH 441106022
//
public interface Locator<T>{
	
	
	// Inserts e at location loc and returns the number of comparisons made when
	// searching for loc.
	int add(T e, Location loc );

	
	// The first element of the returned pair is a list containing all elements
	// located at loc . If loc does not exist or has no elements , the returned list
	// is empty . The second element of the pair is the number of comparisons made
	// when searching for loc .
	Pair < List <T >, Integer > get ( Location loc );
	
	
	// Removes all occurrences of element e from location loc . The first element
	// of the returned pair is true if e is removed and false if loc does not exist
	// or e does not exist in loc . The second element of the pair is the number of
	// comparisons made when searching for loc .
	Pair < Boolean , Integer > remove ( T e , Location loc );

	
	// Returns all locations and the elements they contain .
	List < Pair < Location , List <T >>> getAll () ;

	
	// The first element of the returned pair is a list of all locations and their
	// data if they are located within the rectangle specified by its lower left and
	// upper right corners ( inclusive of the boundaries ). The second element of the
	// pair is the number of comparisons made .
	Pair < List < Pair < Location , List <T >>>, Integer > inRange ( Location lowerLeft , Location upperRight );
}