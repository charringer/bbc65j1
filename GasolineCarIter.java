public class GasolineCarIter implements Iter {
	private VehicleList.Iterator iter;
	private GasolineCar buffer = null;

	public GasolineCarIter(VehicleList.Iterator iter) {
		this.iter = iter;
		skip();
	}

	public boolean hasNext() {
		return (buffer!=null);
	}

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
