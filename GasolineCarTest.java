
public class GasolineCarTest extends Assert {

	@Tst
	public void incrementAndGetFuelConsumption() {
		ElectroCar car = new ElectroCar();
		assertEquals(0, car.getFuelConsumption());

		car.incrementFuelConsumption(2900);
		assertEquals(2900, car.getFuelConsumption());

		car.incrementFuelConsumption(300);
		assertEquals(2900+300, car.getFuelConsumption());
	}
}
