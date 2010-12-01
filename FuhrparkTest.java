
public class FuhrparkTest extends Assert {

	private ElectroCar ecar1, ecar2;
	private GasolineCar gcar1, gcar2;
	private Fuhrpark park, fullPark; 

	@Before 
	public void prepare() {
		park = new Fuhrpark("park");
		fullPark = new Fuhrpark("fullPark");

		ecar1 = new ElectroCar(1);
		ecar1.incrementMileage(1);
		ecar1.incrementPowerConsumption(21);
		PassengerTransportation p = new PassengerTransportation(2);
		ecar1.setPurpose(p);

		ecar2 = new ElectroCar(2);
		ecar2.incrementMileage(2);
		ecar2.incrementPowerConsumption(22);
		GoodsTransportation g = new GoodsTransportation(5, 10);
		ecar2.setPurpose(g);

		gcar1 = new GasolineCar(3);
		gcar1.incrementMileage(3);
		gcar1.incrementFuelConsumption(31);
		p = new PassengerTransportation(8);
		gcar1.setPurpose(p);

		gcar2 = new GasolineCar(4);
		gcar2.incrementMileage(4);
		gcar2.incrementFuelConsumption(32);
		g = new GoodsTransportation(11, 22);
		gcar2.setPurpose(g);

		fullPark.InsertVehicle(ecar1);
		fullPark.InsertVehicle(ecar2);
		fullPark.InsertVehicle(gcar1);
		fullPark.InsertVehicle(gcar2);
	}

	@Tst
	public void insert_shouldInsert() {
		assertFalse(park.has(ecar1));
		park.InsertVehicle(ecar1);	
		assertTrue(park.has(ecar1));
		park.RemoveVehicle(ecar1);
		assertFalse(park.has(ecar1));
	}

	@Tst
	public void get_shouldReturnRightObject() {
		assertEquals(ecar1,fullPark.get(ecar1.getIdentifier()));
	}

	@Tst
	public void calculate_FuelConsumption() {
		assertEquals((31.+32.)/(3.+4.),fullPark.averageFuelConsumption());
	}

	@Tst
	public void calculate_FuelConsumptionPassenger() {
		assertEquals(31./3.,fullPark.averageFuelConsumptionPassengerTransport());
	}

	@Tst
	public void calculate_FuelConsumptionGoods() {
		assertEquals(32./4.,fullPark.averageFuelConsumptionGoodsTransport());
	}
	
	@Tst
	public void calculate_PowerConsumption() {
		assertEquals((21.+22.)/(1.+2.),fullPark.averagePowerConsumption());
	}

	@Tst
	public void calculate_PowerConsumptionPassenger() {
		assertEquals(21./1.,fullPark.averagePowerConsumptionPassengerTransport());
	}

	@Tst
	public void calculate_PowerConsumptionGoods() {
		assertEquals(22./2.,fullPark.averagePowerConsumptionGoodsTransport());
	}

	@Tst 
	public void calculate_averageSeats() {
		assertEquals((2.+8.)/2,fullPark.averageSeats());
	}

	@Tst 
	public void calculate_averageSeatsElectro() {
		assertEquals(2./1,fullPark.averageSeatsOnElectroCars());
	}

	@Tst 
	public void calculate_averageSeatsOnGasolineCars() {
		assertEquals(8./1,fullPark.averageSeatsOnGasolineCars());
	}

	@Tst 
	public void calculate_averageCargoArea() {
		assertEquals((5.+11.)/2,fullPark.averageCargoArea());
	}

	@Tst 
	public void calculate_averageCargoAreaElectro() {
		assertEquals(5./1,fullPark.averageCargoAreaOnElectroCars());
	}

	@Tst 
	public void calculate_averageCargoAreaOnGasolineCars() {
		assertEquals(11./1,fullPark.averageCargoAreaOnGasolineCars());
	}

	/* Test for special case: Fuhrpark empty */
	@Tst
	public void calculate_FuelConsumptionShouldBeZero() {
		assertEquals(0.,park.averageFuelConsumption());
	}

	@Tst
	public void calculate_FuelConsumptionPassengerShouldBeZero() {
		assertEquals(0.,park.averageFuelConsumptionPassengerTransport());
	}

	@Tst
	public void calculate_FuelConsumptionGoodsShouldBeZero() {
		assertEquals(0.,park.averageFuelConsumptionGoodsTransport());
	}
	
	@Tst
	public void calculate_PowerConsumptionShouldBeZero() {
		assertEquals(0.,park.averagePowerConsumption());
	}

	@Tst
	public void calculate_PowerConsumptionPassengerShouldBeZero() {
		assertEquals(0.,park.averagePowerConsumptionPassengerTransport());
	}

	@Tst
	public void calculate_PowerConsumptionGoodsShouldBeZero() {
		assertEquals(0.,park.averagePowerConsumptionGoodsTransport());
	}

	@Tst 
	public void calculate_averageSeatsShouldBeZero() {
		assertEquals(0.,park.averageSeats());
	}

	@Tst 
	public void calculate_averageSeatsElectroShouldBeZero() {
		assertEquals(0.,park.averageSeatsOnElectroCars());
	}

	@Tst 
	public void calculate_averageSeatsOnGasolineCarsShouldBeZero() {
		assertEquals(0.,park.averageSeatsOnGasolineCars());
	}

	@Tst 
	public void calculate_averageCargoAreaShouldBeZero() {
		assertEquals(0.,park.averageCargoArea());
	}

	@Tst 
	public void calculate_averageCargoAreaElectroShouldBeZero() {
		assertEquals(0.,park.averageCargoAreaOnElectroCars());
	}

	@Tst 
	public void calculate_averageCargoAreaOnGasolineCarsShouldBeZero() {
		assertEquals(0.,park.averageCargoAreaOnGasolineCars());
	}
}
