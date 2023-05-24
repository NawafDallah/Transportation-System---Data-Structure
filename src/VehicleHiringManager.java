//
//NAWAF MUSTAFA DALLAH 441106022
//
public class VehicleHiringManager {

	//Attributes
	LocatorMap<String> locatorMap;
    
	
	
	//Constructor
    public VehicleHiringManager () 
    {
    	locatorMap = new TreeLocatorMap <String>();
    }
	
    
    
    
	// Returns the locator map .
	public LocatorMap <String> getLocatorMap () 
	{
	return locatorMap;
	}
	
	
	
	//Sets the locator map .
	public void setLocatorMap(LocatorMap < String > locatorMap ) 
	{
		List<String> Car = locatorMap.getMap().getAll(); 
		
        if(!Car.empty())
        {
        	Car.findFirst();
            while(!Car.last())
            {
                Pair<Location, Integer> loc = locatorMap.getLoc(Car.retrieve());
                locatorMap.add(Car.retrieve(), loc.first);
                
                Car.findNext();
            }
            Pair<Location, Integer> loc = locatorMap.getLoc(Car.retrieve());
            locatorMap.add(Car.retrieve(), loc.first);
        }
	}
	
	
	
	// Inserts the vehicle id at location loc if it does not exist and returns true .
	// If id already exists , the method returns false .
	public boolean addVehicle(String id, Location loc) 
	{
		 Pair<Boolean, Integer> addCar = locatorMap.add(id, loc);
         return addCar.first ;
	}
	
	
	
	
	// Moves the vehicle id to location loc if id exists and returns true . If id not
	// exist , the method returns false .
	public boolean moveVehicle(String id , Location loc)
	{
		Pair<Boolean, Integer> MoveCar = locatorMap.move(id, loc);
        return MoveCar.first ;
	}
	
	
	
	
	// Removes the vehicle id if it exists and returns true . If id does not exist ,
	// the method returns false .
	public boolean removeVehicle ( String id ) 
	{
		Pair<Boolean, Integer> RemoveCar = locatorMap.remove(id);
        return RemoveCar.first ;
	}
	
	
	
	// Returns the location of vehicle id if it exists , null otherwise .
	public Location getVehicleLoc ( String id ) 
	{
		Pair<Location, Integer> Carloc = locatorMap.getLoc(id);
        return Carloc.first;
	}
	
	
	
	// Returns all vehicles located within a square of side 2*r centered at loc
	// ( inclusive of the boundaries ).
	public List < String > getVehiclesInRange ( Location loc , int r) 
	{
	 Pair<List<String>, Integer> pair = locatorMap.getInRange(new Location(loc.x-r, loc.y-r), new Location(loc.x+r, loc.y+r));

		List<String> CarsInRinge = new LinkedList<String>();
		if (!pair.first.empty())
		{
			pair.first.findFirst();
            while(!pair.first.last())
            {
            	CarsInRinge.insert(pair.first.retrieve());
            	pair.first.findNext();
            }
            CarsInRinge.insert(pair.first.retrieve());
        }
		return CarsInRinge;
	}
}