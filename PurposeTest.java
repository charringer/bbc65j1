
public class PurposeTest extends Assert {

	@Tst
	public void goodsTransportation_hasItsPropertiesAndProperType() {
		GoodsTransportation goodsTransportation = new GoodsTransportation(12, 5000);

		assertEquals(12, goodsTransportation.getSizeOfCargoArea());
		assertEquals(5000, goodsTransportation.getMaxNettoWeight());
		assertTrue(goodsTransportation instanceof Purpose);
	}
}
