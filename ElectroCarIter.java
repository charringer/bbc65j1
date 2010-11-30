public class ElectroCarIter implements Iter {
	private VehicleList.Iterator iter;
	private ElectroCar buffer = null;

	public ElectroCarIter(VehicleList.Iterator iter) {
		this.iter = iter;
		skip();
	}

	public boolean hasNext() {
		return (buffer!=null);
	}

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
