
public class GasolineCar extends Vehicle {

	private int fuelConsumption;

	public GasolineCar(int identifier) {
		super(identifier);
	}

	/* returns the fuel consumption in liters >= 0
	 */
	public int getFuelConsumption() {
		return fuelConsumption;
	}

	/* increments the fuel consumption in liters, negatives values not allowed
	 */
	public void incrementFuelConsumption(int incrementation) {
		if (incrementation < 0)
			throw new IllegalArgumentException(
				"incrementation by a value < 0 not allowed");
		fuelConsumption += incrementation;
	}
}
