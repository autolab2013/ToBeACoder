/** 8.4 Design a parking lot using OO principles.
 *  
 */
 
/** I think
 *  ParkingLot:
 *  	multi-levels, different kinds of vehicles, different spots, spot compact/large, bus takes 5 spots 
 *  ParkingLot{ Spot, Vehicle}
 *  ParkingLot{
 *  	capacity;
 *  	Spot;
 *  	Vehicle;
 *  	availabe_spot;
 *  	
 *  	isFull();
 *  	parkVehicle(Vehicle);
 *  	takeOutVehicle(Vehicle);
 *  	checkSpot(Spot);
 *  }
 *  Spot{
 *  	level;
 *  	Category;
 *  	row;
 *  	occupied;
 *  	Vehicle;
 *  	
 *  	canFit(Vehicle);
 *  	isOccupied();
 *  	setOccupied();
 *  	setAvailable();
 *  }
 *  Vehicle{
 *  	level;
 *  	size;
 *  	category;
 *  	Queue Spot;
 *  	
 *  	occupy(Spot);
 *  	leave();
 *  }
 */