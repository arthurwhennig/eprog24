/**
 * A singly-linked list of integer values.
 */
public class LinkedIntList {

	public static void main(String[] args) {
		LinkedIntList list = new LinkedIntList();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);

		System.out.println(list.get(2));
	}
	
	private class IntNode {
	    
	    private int value;
	    private IntNode next;
	    
	    public IntNode(int value) {
	        this.value = value;
	    }
	}

	private IntNode first;
	private IntNode last;
	private int size;
	
    /**
     * Appends 'value' at the end of the list.
     */
    public void addLast(int value) {
    	if (size == 0) {
    		first = new IntNode(value);
    		last = first;
    	} else {
    		IntNode curr = first;
    		while (curr.next != null) {
    			curr = curr.next;
    		}
    		curr.next = new IntNode(value);
    		last = curr.next;
    	}
    	size++;
    }

    /**
     * Inserts 'value' at position 0 in the list.
     */
    public void addFirst(int value) {
    	if (size == 0) {
    		first = new IntNode(value);
    		last = first;
    	} else {
    		IntNode next = first; 
    		first = new IntNode(value);
    		first.next = next;
    		
    	}
    	size++;
    }

    /**
     * Removes and returns the first value of the list.
     */
    public int removeFirst() {
        if (size == 0) Errors.error("Cannot remove first item in empty list.");;
        int value = first.value;
        if (size == 1) {
        	first = null;
        	last = null;
        } else {
        	first = first.next;
        }
        size--;
        return value;
    }

    /**
     * Removes and returns the last value of the list.
     */
    public int removeLast() {
    	if (size == 0) Errors.error("Cannot remove last item in empty list.");;
        int value = last.value;
        if (size == 1) {
        	first = null;
        	last = null;
        } else {
        	IntNode curr = first;
        	while (curr.next.next != null) {
        		curr = curr.next;
        	}
        	curr.next = null;
        	last = curr;
        }
        size--;
        return value;
    }

    /**
     * Removes all values from the list, making the list empty.
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Returns whether the list is empty (has no values).
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the integer value at position 'index'.
     */
    public int get(int index) {
    	if (size <= index) Errors.error("Index out of bounds during get.");;
    	IntNode curr = first;
    	int idx = 0;
    	while (idx < index && curr != null) {
    		curr = curr.next;
    		idx++;
    	}
    	return curr.value;
    }

    /**
     * Sets the integer value at position 'index' to 'value'.
     */
    public void set(int index, int value) {
        if (size <= index) Errors.error("Index out of bounds during set.");
        IntNode curr = first;
        int idx = 0;
        while (idx < index && curr != null) {
        	curr = curr.next;
        	idx++;
        }
        curr.value = value;
    }

    /**
     * Returns the size of the list.
     */
    public int getSize() {
        return size;
    }
}
