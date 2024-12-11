package lists;
import java.util.NoSuchElementException;

public class CircularLinkedIntList implements IntList {

	private IntNode last;
	private int size;
	

	public IntNode getLast() {
		return last;
	}

	public void setLast(IntNode last) {
		this.last = last;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Return the integer value at position 'index'
	 */
	public int get(int index) {
		return getNode(index).getValue();
	}

	/**
	 * Set the integer value at position 'index' to 'value'
	 */
	public void set(int index, int value) {
		getNode(index).setValue(value);
	}

	/**
	 * Returns whether the list is empty (has no values)
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the size of the list
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Inserts 'value' at position 0 in the list.
	 */
	public void addFirst(int value) {
		IntNode newNode = new IntNode(value);
		if (last == null) {
			last = newNode;
		} else {
			newNode.setNext(last.getNext());
		}

		last.setNext(newNode);
		size += 1;
	}

	/**
	 * Appends 'value' at the end of the list.
	 */
	public void addLast(int value) {
		IntNode newNode = new IntNode(value);

		if (last == null) {
			last = newNode;
		} else {
			newNode.setNext(last.getNext());
		}
		last.setNext(newNode);
		last = newNode;
		size += 1;
	}

	/**
	 * Removes and returns the first value of the list.
	 * Throws a NoSuchElementException if the List is empty.
	 */
	public int removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("removeFirst() on empty list!");
		}

		int value = last.getNext().getValue();
		if (size == 1) {
			// List has only one element, so just clear it
			clear();
		} else {
			last.setNext(last.getNext().getNext());
			size -= 1;
		}

		return value;
	}

	/**
	 * Removes and returns the last value of the list.
	 * Throws a NoSuchElementException if the List is empty.
	 */
	public int removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("removeFirst() on empty list!");
		}

		int value = last.getValue();
		if (size == 1) {
			// List has only one element, so just clear it
			clear();
		} else {
			// List has more than one element
			IntNode newLast = getNode(size - 2);
			newLast.setNext(last.getNext());
			last = newLast;
			size -= 1;
		}
		return value;
	}

	/**
	 * Removes all values from the list, making the list empty.
	 */
	public void clear() {
		last = null;
		size = 0;
	}

	/**
	 * Returns a new int-array with the same contents as the list.
	 */
	public int[] toArray() {
		int[] array = new int[size];

		if (size != 0) {
			IntNode n = last.getNext();
			for (int i = 0; i < size; i += 1) {
				array[i] = n.getValue();
				n = n.getNext();
			}
		}

		return array;
	}

	/**
	 * For internal use only.
	 */
	public IntNode getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("getNode() with invalid index: " + index);
		}

		IntNode current = last.getNext();
		for (int i = 0; i < index; i += 1) {
			current = current.getNext();
		}

		return current;
	}
}
