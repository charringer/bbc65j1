public class FuhrparkSet {
	private class FuhrparkNode {
		public FuhrparkNode next;
		public Fuhrpark value;
		public FuhrparkNode(FuhrparkNode next, Fuhrpark value) {
			this.next = next;
			this.value = value;
		}
	}

	FuhrparkNode start = null;

	public boolean insert(Fuhrpark newFuhrpark) {
		if(this.get(newFuhrpark.getName())!=null) return false;
		FuhrparkNode nn = this.new FuhrparkNode(start, newFuhrpark);
		start = nn;
		return true;
	}

	public Fuhrpark get(String name) {
		FuhrparkNode c = start;
		while(c!=null) {
			if(c.value.getName().compareTo(name)==0)
				return c.value;
			c = c.next;
		}
		return null;
	}

}
