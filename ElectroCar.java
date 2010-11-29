
public class ElectroCar extends Vehicle {

	private int powerConsumption;


	public ElectroCar(int identifier) {
		super(identifier);
	}

	/* returns the power consumption in kilowatthours >= 0
	 */
	public int getPowerConsumption() {
		return powerConsumption;
	}

	/* increments the power consumption in kilowatthours, negatives values not allowed
	 */
	public void incrementPowerConsumption(int incrementation) {
		if (incrementation < 0)
			throw new IllegalArgumentException(
				"incrementation by a value < 0 not allowed");
		powerConsumption += incrementation;
	}
}
