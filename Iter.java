
public interface Iter<T> {
	/* returns object of type T or null, subsequent calls to next 
	 * may return other objects (or null), may throw NullPointerException */
	T next();
	/* returns false if all subsequent calls to next will throw 
	 * NullPointerException, true otherwise */
	boolean hasNext();
}
