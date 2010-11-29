public class Fuhrpark {
	private VehicleList vehicles;
	private String name;

	public Fuhrpark(String name) {
		this.name = name;
		vehicles = new VehicleList();
	}

	public void InsertVehicle(Vehicle vehicle) {
		vehicles.push(vehicle);
	}

	public void RemoveVehicle(Vehicle vehicle) {
		int identifier = vehicle.getIdentifier();
		VehicleList.Iterator iter = vehicles.iter();
		while(iter.hasNext()) {
			Vehicle v = iter.next();
			if(v.getIdentifier() == identifier)
				iter.delete();
		}
	}

	public boolean has(Vehicle vehicle) {
		int identifier = vehicle.getIdentifier();
		VehicleList.Iterator iter = vehicles.iter();
		while(iter.hasNext()) {
			Vehicle v = iter.next();
			if(v.getIdentifier() == identifier)
				return true;
		}
		return false;
	}
}

