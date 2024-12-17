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
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int get(int idx) {
		return 0;
	}
	
	public void addLast(int item) {
		
	}
	@Override
	public void set(int index, int value) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addFirst(int value) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int removeFirst() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int removeLast() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
