package lists;
/**
 * A singly-linked list of integer values with fast addFirst and addLast methods
 */
public class LinkedIntList implements IntList{
    
    IntNode first;
    IntNode last;
    int size;
    
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
     * Returns whether 'value' is contained in the list.
     */
    public boolean contains(int value) {
    	for(IntNode n = first; n != null; n = n.getNext()) {
    		if (n.getValue() == value) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Inserts 'value' at position 0 in the list.
     */
    public void addFirst(int value) {
        IntNode newNode = new IntNode(value);
        newNode.setNext(first);
        first = newNode;
        if(last == null) {
        	last = newNode;
        }
            
        size++;
    }
    
    /**
     * Appends 'value' at the end of the list.
     */
    public void addLast(int value) {
        IntNode newNode = new IntNode(value);
        if(isEmpty()) {
        	first = newNode;
        } else {
        	last.setNext(newNode);
        }
        
        last = newNode;
        size++;
    }
    
    /**
     * Removes and returns the first value of the list.
     */
    public int removeFirst() {
        if(isEmpty()) {
        	throw new IllegalArgumentException("removeFirst() on empty list!");
        }
        
        int value = first.getValue();
        if(first == last) {
            // List has only one element, so just clear it
            clear();
        } else {
            first = first.getNext();
            size--;
        }
        
        return value;
    }

    /**
     * Removes and returns the last value of the list.
     */
    public int removeLast() {
        if(isEmpty()) {
        	throw new IllegalArgumentException("removeLast() on empty list!");
        }
        
        int value = last.getValue();
        if(first == last) {
            // List has only one element, so just clear it
            clear();
        }
        else {
            // List has more than one element
            IntNode currentNode = first;
            while(currentNode.getNext() != last) {
            	currentNode = currentNode.getNext();
            }
            
            currentNode.setNext(null);
            last = currentNode;
            size--;
        }
        return value;
    }
    
    /**
     * Removes all values from the list, making the list empty.
     */
    public void clear() {
        first = last = null;
        size = 0;
    }
    
    /**
     * Returns a new int-array with the same contents as the list.
     */
    public int[] toArray() {
        int[] array = new int[size];
        int i = 0;
        for(IntNode n = first; n != null; n = n.getNext(), i++) {
        	array[i] = n.getValue();
        }
            
        return array;
    }
    
    /**
     * For internal use only.
     */
    IntNode getNode(int index) {
        if(index < 0 || index >= size) {
        	throw new IllegalArgumentException("getNode() with invalid index: " + index);
        }
        
        IntNode current = first;
        for(int i = 0; i < index; i++) {
        	current = current.getNext();
        }
            
        return current;
    }

	@Override
	public int getSize() {
		return this.size;
	}
}
