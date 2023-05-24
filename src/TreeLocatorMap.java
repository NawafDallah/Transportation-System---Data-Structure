//
//NAWAF MUSTAFA DALAH_441106022
//
public class TreeLocatorMap<K extends Comparable <K>> implements LocatorMap<K> {

	
	//Attributes
	Locator<K> locator;
	Map<K, Location> map;
	
	
	//Constructor
	public TreeLocatorMap() 
	{
		locator = new TreeLocator<K>();
		map = new BST<K, Location>();
	}
	
	
	
	//Methods
	
	
	// Returns a map with the location of every key .
		public Map <K, Location> getMap() {
			return map;
		}
		
		// Returns a locator that contains all keys .
		public Locator <K> getLocator() 
		{
			return locator;
		}
	
	

		
		
		
		// Inserts the key k at location loc if it does not exist . The first element of
		// the returned pair indicates whether k was inserted , and the second is the
		// number of key comparisons made .
		public Pair<Boolean, Integer> add(K k, Location loc)
		{
           // Pair < Boolean , Integer >pair;
            boolean found = false;
            
                Pair<Boolean , Integer> InsetInMap = map.insert(k, loc);
                if(InsetInMap.first) // Not added before
                {
                	locator.add(k, loc);//added in locator
                	found = true;
                    return new Pair < Boolean , Integer >(found, InsetInMap.second);
                }
            else // added before 
               return new Pair<Boolean , Integer>(found, InsetInMap.second);	
		}
		
		
		
		
		
		// Moves the key k to location loc if k exists . The first element of
		// the returned pair indicates whether k exists , and the second is the
		// number of key comparisons made .
		public Pair<Boolean, Integer> move(K k , Location loc )
		{ 
            Pair < Boolean , Integer>  searchInMap = map.find(k);
            boolean found = false;
            if(searchInMap.first)// if k exists --> move it 
            {
                Pair < Boolean , Integer>  RemoveFromLocator = locator.remove(k, map.retrieve());
                map.update(loc);
                locator.add(k, loc);
                    found = true;
                return new Pair < Boolean , Integer >(found, searchInMap.second);   
            }
            else//k is not exists --> can't move it 
                return new Pair < Boolean , Integer >(found, searchInMap.second);   
		}
		
		
		
		
		
		// The first element of the returned pair contains the location of key k if it
		// exists , null otherwise . The second element is the number of key comparisons
		// required to find k.
		public Pair<Location, Integer> getLoc(K k)
		{
			 Pair <Boolean , Integer> searchInMap = map.find(k);

	            if(searchInMap.first)//found
	                return new Pair <Location , Integer> (map.retrieve(), searchInMap.second);
	                
	            //not found
	            return (new Pair<Location , Integer> (null, searchInMap.second));
		}
		
	
		
		
		
		// Removes the element with key k if it exists.The first element of the
		// returned pair indicates whether k was removed , and the second is the number
		// of key comparisons required to find k.
		public Pair<Boolean, Integer> remove(K k)
		{
			Pair<Boolean, Integer> searchInMap = map.find(k);
			boolean found = false;
			if(searchInMap.first) 
			{
				Pair<Boolean, Integer> RemoveFromLocator = locator.remove(k, map.retrieve());
				map.remove(k);
				found = true;
				return new Pair<Boolean, Integer>(found, searchInMap.second);
			}
			else
				return new Pair<Boolean, Integer>(found, searchInMap.second);
		}        
		
		
		
		
		//Returns all keys in the map sorted in increasing order.
		public List<K> getAll()
		{
			return map.getAll();
		}
		
		
		
		
		// The first element of the returned pair is a list of all keys located within
		// the rectangle specified by its lower left and upper right corners ( inclusive
		// of the boundaries ). The second element of the pair is the number of
		// comparisons made .
		public Pair<List<K>, Integer> getInRange(Location lowerLeft, Location upperRight)
		{
			
			List <K > CarsInRange = new LinkedList <K >();		
            Pair <List<Pair<Location, List<K>>>, Integer > pair = locator.inRange(lowerLeft, upperRight);
            List<Pair<Location, List<K>>> AllData = pair.first;
            if (!AllData.empty())
            {
                AllData.findFirst();
                while (!AllData.last())
                {
                       // insert all cars in same location
                        if (!AllData.retrieve().second.empty())
                        {
                            AllData.retrieve().second.findFirst();
                            while (!AllData.retrieve().second.last())
                            {
                            	CarsInRange.insert(AllData.retrieve().second.retrieve());
                                AllData.retrieve().second.findNext();
                            }
                            //add last node in AllData.retrieve().second
                            CarsInRange.insert(AllData.retrieve().second.retrieve());
                        }
                    AllData.findNext();
                }
                // manipulating last node in AllData
                if (!AllData.retrieve().second.empty())
                {
                    AllData.retrieve().second.findFirst();
                    while ( ! AllData.retrieve().second.last())
                    {
                    	CarsInRange.insert(AllData.retrieve().second.retrieve());
                        AllData.retrieve().second.findNext();
                    }
                    // add last node in AllData.retrieve().second
                    CarsInRange.insert(AllData.retrieve().second.retrieve());
                }
            }
            return new Pair <List <K >, Integer >(CarsInRange, pair.second);
		} 	
}