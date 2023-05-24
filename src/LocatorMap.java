//
//NAWAF MUSTAFA DALLAH_441106022
//
public interface LocatorMap<K extends Comparable <K>>{

	
	// Returns a map with the location of every key .
	Map <K , Location > getMap () ;

	// Returns a locator that contains all keys .
	Locator <K > getLocator () ;

	
	
	
	// Inserts the key k at location loc if it does not exist . The first element of
	// the returned pair indicates whether k was inserted , and the second is the
	// number of key comparisons made .
	Pair < Boolean , Integer > add (K k , Location loc ) ;

	
	
	
	
	// Moves the key k to location loc if k exists . The first element of
	// the returned pair indicates whether k exists , and the second is the
	// number of key comparisons made .
	Pair < Boolean , Integer > move (K k , Location loc );



	

	// The first element of the returned pair contains the location of key k if it
	// exists , null otherwise . The second element is the number of key comparisons
	// required to find k.
	Pair < Location , Integer > getLoc (K k);

	
	
	
	
	// Removes the element with key k if it exists . . The first element of the
	// returned pair indicates whether k was removed , and the second is the number
	// of key comparisons required to find k.
	Pair < Boolean , Integer > remove ( K k );

	
	
	
	// Returns all keys in the map sorted in increasing order.
	List <K > getAll () ;

	
	
	
	
	// The first element of the returned pair is a list of all keys located within
	// the rectangle specified by its lower left and upper right corners ( inclusive
	// of the boundaries ). The second element of the pair is the number of
	// comparisons made .
	Pair < List <K >, Integer > getInRange ( Location lowerLeft , Location upperRight ) ;
}