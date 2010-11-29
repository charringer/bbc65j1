
public class Vehicle {

	private int mileage;
	private Purpose purpose;

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

	/* set the purpose of the vehicle; the old purpose will be discarded
	 */
	public void setPurpose(Purpose newPurpose) {
		this.purpose = newPurpose;
	}

	/* return the purpose of the vehicle; possibly null
	 */
	public Purpose getPurpose() {
		return purpose;
	}
}
