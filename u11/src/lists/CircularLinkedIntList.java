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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	// TODO: Implementieren Sie die Methoden für das IntList Interface
}
