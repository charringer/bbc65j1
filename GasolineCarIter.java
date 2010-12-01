public class GasolineCarIter implements Iter {
	private VehicleList.Iterator iter;
	private GasolineCar buffer = null;

	/* the GasolineCarIter iterates over all GasolineCars
	 * in the "iter" */
	public GasolineCarIter(VehicleList.Iterator iter) {
		this.iter = iter;
		skip();
	}

	/* returns true if the iterator has another GasolineCar */
	public boolean hasNext() {
		return (buffer!=null);
	}

	/* returns the next GasolineCar in "iter" or null if
	 * the iter has no more ElectorCars */
	public GasolineCar next() {
		GasolineCar b = buffer;
		skip();
		return b;
	}

	private void skip() {
		buffer = null;
		while(buffer == null) {
			if(!iter.hasNext())
				return;
			Vehicle v = iter.next();
			if(v instanceof GasolineCar)
				buffer = ((GasolineCar)v);
		}
	}
}
