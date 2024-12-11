package lists;


/**
 * A node of a singly-linked list of integer values
 */
public class IntNode {
    
    private int value;
    private IntNode next;
    
    public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public IntNode getNext() {
		return next;
	}

	public void setNext(IntNode next) {
		this.next = next;
	}

	public IntNode(int value) {
        this.value = value;
    }
}
