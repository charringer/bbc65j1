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

	public double averageFuelConsumption() {
		return filteredFuelConsumption(Object.class);
	}

	public double averageFuelConsumptionPassengerTransport() {
		return filteredFuelConsumption(PassengerTransportation.class);
	}

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

	public double averagePowerConsumption() {
		return filteredPowerConsumption(Object.class);
	}

	public double averagePowerConsumptionPassengerTransport() {
		return filteredPowerConsumption(PassengerTransportation.class);
	}

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

	public double averageSeats() {
		return averageSeatsFromIter(vehicles.iter()); 
	}

	public double averageSeatsOnElectroCars() {
		return averageSeatsFromIter(vehicles.ElectroCarIter());
	}

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

	public double averageCargoArea() {
		return averageCargoAreaFromIter(vehicles.iter()); 
	}

	public double averageCargoAreaOnElectroCars() {
		return averageCargoAreaFromIter(vehicles.ElectroCarIter());
	}

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

