
public class SpecialIterTest extends Assert {

	private Vehicle car1,car2,car3,car4;
	private VehicleList l;
	@Before 
	public void prepare() {
		car1 = new GasolineCar(1);
		car2 = new ElectroCar(2);
		car3 = new GasolineCar(3);
		car4 = new GasolineCar(4);

		l = new VehicleList();
		l.push(car1);
		l.push(car2);
		l.push(car3);
		l.push(car4);
	}

	@Tst
	public void ElectroCarIter_shouldIterOver() {

		ElectroCarIter i = l.ElectroCarIter();
		assertTrue(i.hasNext());
		assertEquals(car2, i.next());
		assertFalse(i.hasNext());
	}

	@Tst
	public void GasolineCarIter_shouldIterOver() {

		GasolineCarIter i = l.GasolineCarIter();
		assertTrue(i.hasNext());
		assertEquals(car1, i.next());
		assertTrue(i.hasNext());
		assertEquals(car3, i.next());
		assertTrue(i.hasNext());
		assertEquals(car4, i.next());
		assertFalse(i.hasNext());
	}
}
