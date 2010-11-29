
public class FuhrparkTest extends Assert {

	@Tst
	public void insert_shouldInsert() {
		ElectroCar car = new ElectroCar(1);
		Fuhrpark park = new Fuhrpark("park");
		assertFalse(park.has(car));
		park.InsertVehicle(car);	
		assertTrue(park.has(car));
		park.RemoveVehicle(car);
		assertFalse(park.has(car));
	}
}
