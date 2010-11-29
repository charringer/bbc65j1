
public class LinkedListNode<T> {
	private LinkedListNode<T> next;
	private T value;

	/* saves the value and the next node */
	public LinkedListNode(LinkedListNode<T> next, T value) {
		setNext(next);
		setValue(value);
	}

	/* returns the next node */
	public LinkedListNode<T> getNext() {
		return next;
	}

	/* changes the next node to next */
	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	/* returns the saved value */
	public T getValue() {
		return value;
	}

	/* changes value to value */
	public void setValue(T value) {
		this.value = value;
	}
}
