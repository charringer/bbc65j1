
public class PassengerTransportation implements Purpose {

	private int numberOfSeats;

	public PassengerTransportation(int numberOfSeats) {
		if (numberOfSeats < 0)
			throw new IllegalArgumentException("negative values not allowed");
		this.numberOfSeats = numberOfSeats;
	}

	/* get the number of seats >= 0
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
}
