
public class GoodsTransportation implements Purpose {

	private int sizeOfCargoArea;
	private int maxNettoWeight;

	public GoodsTransportation(int sizeOfCargoArea, int maxNettoWeight) {
		if (sizeOfCargoArea < 0 || maxNettoWeight < 0)
			throw new IllegalArgumentException("negative values not allowed");
		this.sizeOfCargoArea = sizeOfCargoArea;
		this.maxNettoWeight = maxNettoWeight;
	}

	/* get the size of the cargo area in square meters >= 0
	 */
	public int getSizeOfCargoArea() {
		return sizeOfCargoArea;
	}

	/* get the maximum netto weight in kilogram >= 0
	 */
	public int getMaxNettoWeight() {
		return maxNettoWeight;
	}
}
