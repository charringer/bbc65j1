
public class Vehicle {

	private int mileage;

	protected Vehicle() {
		mileage = 0;
	}

	/* returns the mileage in kilometers >= 0
	 */
	public int getMileage() {
		return mileage;
	}

	/* increments the mileage in kilometers, negatives values not allowed
	 */
	public void incrementMileage(int incrementation) {
		if (incrementation < 0)
			throw new IllegalArgumentException(
				"incrementation by a value < 0 not allowed");
		mileage += incrementation;
	}
}
