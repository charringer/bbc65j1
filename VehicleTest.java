
public class VehicleTest extends Assert {

	@Tst
	public void incrementAndGetMileage() {
		Vehicle car = new GasolineCar(1);
		assertEquals(0, car.getMileage());

		car.incrementMileage(23400);
		assertEquals(23400, car.getMileage());

		car.incrementMileage(90);
		assertEquals(23400+90, car.getMileage());
	}

	@Tst(expected = IllegalArgumentException.class)
	public void incrementMileage_cannotDecrement() {
		Vehicle car = new GasolineCar(1);

		car.incrementMileage(-500);
	}

	@Tst
	public void setAndGetPurpose() {
		Vehicle car = new ElectroCar(1);

		assertFalse(car.getPurpose() instanceof PassengerTransportation);
		assertFalse(car.getPurpose() instanceof GoodsTransportation);

		car.setPurpose(new PassengerTransportation(9));

		assertTrue(car.getPurpose() instanceof PassengerTransportation);
		assertEquals(9, ((PassengerTransportation)car.getPurpose()).getNumberOfSeats());

		car.setPurpose(new GoodsTransportation(14, 4500));

		assertTrue(car.getPurpose() instanceof GoodsTransportation);
		assertEquals(14, ((GoodsTransportation)car.getPurpose()).getSizeOfCargoArea());
		assertEquals(4500, ((GoodsTransportation)car.getPurpose()).getMaxNettoWeight());
	}
}
