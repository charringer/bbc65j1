
public class VehicleList {

	private VehicleListNode start;

	/* prepends value to the beginning of the list
	 * e.g.: if the list is [1,2,3] prepending 7 results
	 * in [7,1,2,3] */
	public void unshift(Vehicle value) {
		start = new VehicleListNode(start, value);
	}
	
	/* removes the value from the beginning of the list
	 * and returns it */
	public Vehicle shift() {
		Vehicle head = head();
		start = start.getNext();
		return head;
	}
	
	/* returns the value at the beginning of the list */
	public Vehicle head() {
		return start.getValue(); 
	}
	
	/* appends value to the end of the list */
	public void push(Vehicle value) {
		Iterator it = iter();
		while (it.hasNext()) {
			it.next();
		}
		it.insert(value);
	}
	
	/* removes the value from the end of the list
	 * and returns it */
	public Vehicle pop() {
		Iterator it = iter();
		while (it.hasNext()) {
			it.next();
		}
		Vehicle value = it.lookBack();
		it.delete();
		return value;
	}
	
	/* returns true iff the list contains no elements */
	public boolean isEmpty() {
		return start == null;
	}

	/* returns new LinkedList.Iterator set to the
	 * first element of the list */
	public Iterator iter() {
		return new Iterator(start);
	}

	public class Iterator {
		private VehicleListNode secondLast, last, cur;

		/* sets the element the iterator starts with to start 
		 * the first call to next() returns the value of the 
		 * start element */
		public Iterator(VehicleListNode start) {
			cur = start;
		}

		/* returns true if current element is not the last
		 * element */
		public boolean hasNext() {
			return cur != null;
		}

		/* returns value of current element and sets current
		 * element to the next element */
		public Vehicle next() {
			Vehicle val = peek();
			secondLast = last;
			last = cur;
			cur = cur.getNext();
			return val;
		}

		/* removes the current element from the list */
		public boolean delete() {
			if (last == null) {
				return false;
			}

			if (secondLast == null) {
				last = null;
				start = cur;
			} else {
				secondLast.setNext(cur);
				last = secondLast;
			}
			return true;
		}

		/* returns value of current element */
		public Vehicle peek() {
			return cur.getValue();
		}
		
		/* returns value of previous element */
		public Vehicle lookBack() {
			return last.getValue();
		}

		/* inserts the new element before the current
		 * element */
		public boolean insert(Vehicle elem) {
			if (last == null) {
				unshift(elem);
				return true;
			}
			if (cur == null && last != null) {
				last.setNext(new VehicleListNode(null, elem));
				return true;
			}
			if (cur != null && last != null) {
				VehicleListNode node = new VehicleListNode(cur, elem);
				last.setNext(node);
				secondLast = last;
				last = node;
				return true;
			}
			return false;
		}
	}
}
