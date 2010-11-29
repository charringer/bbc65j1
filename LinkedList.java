
public class LinkedList<T> {
	private LinkedListNode<T> start;

	/* prepends value to the beginning of the list
	 * e.g.: if the list is [1,2,3] prepending 7 results
	 * in [7,1,2,3] */
	public void unshift(T value) {
		start = new LinkedListNode<T>(start, value);
	}
	
	/* removes the value from the beginning of the list
	 * and returns it */
	public T shift() {
		T head = head();
		start = start.getNext();
		return head;
	}
	
	/* returns the value at the beginning of the list */
	public T head() {
		return start.getValue(); 
	}
	
	/* appends value to the end of the list */
	public void push(T value) {
		Iterator it = iter();
		while (it.hasNext()) {
			it.next();
		}
		it.insert(value);
	}
	
	/* removes the value from the end of the list
	 * and returns it */
	public T pop() {
		Iterator it = iter();
		while (it.hasNext()) {
			it.next();
		}
		T value = it.lookBack();
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

	public class Iterator implements Iter<T> {
		private LinkedListNode<T> secondLast, last, cur;

		/* sets the element the iterator starts with to start 
		 * the first call to next() returns the value of the 
		 * start element */
		public Iterator(LinkedListNode<T> start) {
			cur = start;
		}

		/* returns true if current element is not the last
		 * element */
		public boolean hasNext() {
			return cur != null;
		}

		/* returns value of current element and sets current
		 * element to the next element */
		public T next() {
			T val = peek();
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
		public T peek() {
			return cur.getValue();
		}
		
		/* returns value of previous element */
		public T lookBack() {
			return last.getValue();
		}

		/* inserts the new element before the current
		 * element */
		public boolean insert(T elem) {
			if (last == null) {
				unshift(elem);
				return true;
			}
			if (cur == null && last != null) {
				last.setNext(new LinkedListNode<T>(null, elem));
				return true;
			}
			if (cur != null && last != null) {
				LinkedListNode<T> node = new LinkedListNode<T>(cur, elem);
				last.setNext(node);
				secondLast = last;
				last = node;
				return true;
			}
			return false;
		}
	}
}
