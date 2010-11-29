
public class VehicleTest extends Assert {

	@Tst
	public void incrementAndGetMileage() {
		Vehicle car = new GasolineCar();
		assertEquals(0, car.getMileage());

		car.incrementMileage(23400);
		assertEquals(23400, car.getMileage());
	}

	@Tst(expected = IllegalArgumentException.class)
	public void incrementMileage_CannotDecrement() {
		Vehicle car = new GasolineCar();

		car.incrementMileage(-500);
	}
}
