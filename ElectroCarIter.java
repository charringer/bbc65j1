public class ElectroCarIter implements Iter {
	private VehicleList.Iterator iter;
	private ElectroCar buffer = null;

	/* the ElectroCarIter iterates over all ElectroCars
	 * in the "iter" */
	public ElectroCarIter(VehicleList.Iterator iter) {
		this.iter = iter;
		skip();
	}

	/* returns true if the iterator has another ElectroCar */
	public boolean hasNext() {
		return (buffer!=null);
	}

	/* returns the next ElectroCar in "iter" or null if
	 * the iter has no more ElectorCars */
	public ElectroCar next() {
		ElectroCar b = buffer;
		skip();
		return b;
	}

	private void skip() {
		buffer = null;
		while(buffer == null) {
			if(!iter.hasNext())
				return;
			Vehicle v = iter.next();
			if(v instanceof ElectroCar)
				buffer = ((ElectroCar)v);
		}
	}
}
