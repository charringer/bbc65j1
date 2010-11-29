
public class VehicleListNode {
	private VehicleListNode next;
	private Vehicle value;

	/* saves the value and the next node */
	public VehicleListNode(VehicleListNode next, Vehicle value) {
		setNext(next);
		setValue(value);
	}

	/* returns the next node */
	public VehicleListNode getNext() {
		return next;
	}

	/* changes the next node to next */
	public void setNext(VehicleListNode next) {
		this.next = next;
	}

	/* returns the saved value */
	public Vehicle getValue() {
		return value;
	}

	/* changes value to value */
	public void setValue(Vehicle value) {
		this.value = value;
	}
}
