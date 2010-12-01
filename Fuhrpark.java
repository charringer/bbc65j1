public class Fuhrpark {
	private VehicleList vehicles;
	private String name;

	/* saves name */
	public Fuhrpark(String name) {
		this.name = name;
		vehicles = new VehicleList();
	}

	/* returns saved name */
	public String getName() { return this.name; }

	/* insert vehicle into the "Fuhrpark" */
	public void InsertVehicle(Vehicle vehicle) {
		vehicles.push(vehicle);
	}

	/* removes the first occurence of a vehicle with the 
	 * same identifier as vehicle from the "Furpark" */
	public void RemoveVehicle(Vehicle vehicle) {
		RemoveVehicle(vehicle.getIdentifier());
	}

	/* removes the first occurence of a vehicle with the 
	 * same identifier from the "Furpark" */
	public void RemoveVehicle(int identifier) {
		VehicleList.Iterator iter = vehicles.iter();
		while(iter.hasNext()) {
			Vehicle v = iter.next();
			if(v.getIdentifier() == identifier)
				iter.delete();
		}
	}

	/* returns true if the "Fuhrpark" has a vehicle 
	 * with the same identifier as vehicle */
	public boolean has(Vehicle vehicle) {
		return has(vehicle.getIdentifier());
	}

	/* returns true if the "Fuhrpark" has a vehicle
	 * with the identifier "identifier" */
	public boolean has(int identifier) {
		VehicleList.Iterator iter = vehicles.iter();
		while(iter.hasNext()) {
			Vehicle v = iter.next();
			if(v.getIdentifier() == identifier)
				return true;
		}
		return false;
	}

	/* returns first occurence of a vehicle with "identifier" 
	 * in the "Fuhrpark" */
	public Vehicle get(int identifier) {
		VehicleList.Iterator iter = vehicles.iter();
		while(iter.hasNext()) {
			Vehicle v = iter.next();
			if(v.getIdentifier() == identifier)
				return v;
		}
		return null;
	}

	/* returns average fuel consumption of all vehicles */
	public double averageFuelConsumption() {
		return filteredFuelConsumption(Object.class);
	}

	/* returns average fuel consumption of all passenger transport vehicles */
	public double averageFuelConsumptionPassengerTransport() {
		return filteredFuelConsumption(PassengerTransportation.class);
	}

	/* returns average fuel consumption of all goods transport vehicles */
	public double averageFuelConsumptionGoodsTransport() {
		return filteredFuelConsumption(GoodsTransportation.class);
	}

	private double filteredFuelConsumption(Class purpose) {
		double m=0;
		double l=0;
		GasolineCarIter i = vehicles.GasolineCarIter();
		while(i.hasNext()) {
			GasolineCar c = i.next();
			if(purpose.isInstance(c.getPurpose())) {
				m += c.getMileage();
				l += c.getFuelConsumption();
			}
		}
		if(m!=0) return l/m;
		else return 0;
	}

	/* returns average power consumption of all vehicles */
	public double averagePowerConsumption() {
		return filteredPowerConsumption(Object.class);
	}

	/* returns average power consumption of all passenger transport vehicles */
	public double averagePowerConsumptionPassengerTransport() {
		return filteredPowerConsumption(PassengerTransportation.class);
	}

	/* returns average power consumption of all goods transport vehicles */
	public double averagePowerConsumptionGoodsTransport() {
		return filteredPowerConsumption(GoodsTransportation.class);
	}

	private double filteredPowerConsumption(Class purpose) {
		double m=0;
		double l=0;
		ElectroCarIter i = vehicles.ElectroCarIter();
		while(i.hasNext()) {
			ElectroCar c = i.next();
			if(purpose.isInstance(c.getPurpose())) {
				m += c.getMileage();
				l += c.getPowerConsumption();
			}
		}
		if(m!=0) return l/m;
		else return 0;
	}

	/* returns average seats of all vehicles (which have purpose "PassengerTransportation)*/
	public double averageSeats() {
		return averageSeatsFromIter(vehicles.iter()); 
	}

	/* returns average seats of all electro cars (which have purpose "PassengerTransportation") */
	public double averageSeatsOnElectroCars() {
		return averageSeatsFromIter(vehicles.ElectroCarIter());
	}

	/* returns average seats of all gasoline cars (which have purpose "PassengerTransportation") */
	public double averageSeatsOnGasolineCars() {
		return averageSeatsFromIter(vehicles.GasolineCarIter());
	}

	private double averageSeatsFromIter(Iter i) {
		int n = 0;
		double s = 0;
		while(i.hasNext()) {
			Vehicle v = i.next();
			if(v.getPurpose() instanceof PassengerTransportation) {
				n++;
				PassengerTransportation p = (PassengerTransportation)v.getPurpose();
				s+=p.getNumberOfSeats();
			}
		}
		if(n!=0) return s/n;
		else return 0;
	}

	/* returns average seats of all vehicles (which have purpose "GoodsTransportation") */
	public double averageCargoArea() {
		return averageCargoAreaFromIter(vehicles.iter()); 
	}

	/* returns average seats of all electro cars (which have purpose "GoodsTransportation") */
	public double averageCargoAreaOnElectroCars() {
		return averageCargoAreaFromIter(vehicles.ElectroCarIter());
	}

	/* returns average seats of all gasoline cars (which have purpose "GoodsTransportation") */
	public double averageCargoAreaOnGasolineCars() {
		return averageCargoAreaFromIter(vehicles.GasolineCarIter());
	}

	private double averageCargoAreaFromIter(Iter i) {
		int n = 0;
		double s = 0;
		while(i.hasNext()) {
			Vehicle v = i.next();
			if(v.getPurpose() instanceof GoodsTransportation) {
				n++;
				GoodsTransportation p = (GoodsTransportation)v.getPurpose();
				s+=p.getSizeOfCargoArea();
			}
		}
		if(n!=0) return s/n;
		else return 0;
	}
}

