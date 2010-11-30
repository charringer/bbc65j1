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
		return averageFuelConsumptionGoodsTransport() + 
			averageFuelConsumptionPassengerTransport();
	}

	public double averageFuelConsumptionPassengerTransport() {
		return filteredFuelConsumption(PassengerTransportation.class);
	}

	public double averageFuelConsumptionGoodsTransport() {
		return filteredFuelConsumption(GoodsTransportation.class);
	}

	private double filteredFuelConsumption(Class purpose) {
		int m=0;
		int l=0;
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
		return averagePowerConsumptionGoodsTransport() + 
			averagePowerConsumptionPassengerTransport();
	}

	public double averagePowerConsumptionPassengerTransport() {
		return filteredPowerConsumption(PassengerTransportation.class);
	}

	public double averagePowerConsumptionGoodsTransport() {
		return filteredPowerConsumption(GoodsTransportation.class);
	}

	private double filteredPowerConsumption(Class purpose) {
		int m=0;
		int l=0;
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

}

