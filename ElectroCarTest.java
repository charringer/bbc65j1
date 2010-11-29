
public class ElectroCarTest extends Assert {

	@Tst
	public void incrementAndGetPowerConsumption() {
		ElectroCar car = new ElectroCar(1);
		assertEquals(0, car.getPowerConsumption());

		car.incrementPowerConsumption(14400);
		assertEquals(14400, car.getPowerConsumption());

		car.incrementPowerConsumption(800);
		assertEquals(14400+800, car.getPowerConsumption());
	}
}
