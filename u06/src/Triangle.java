
import java.util.Arrays;

public class Triangle {
	
	int rowMax;
	int colMax;
	int[][] rows;
	
	public Triangle(int z, int s) {
		if (z <= 1 || s <= 1) {
			throw new IllegalArgumentException();
		} else {
			rowMax = z;
			colMax = s;
		}
		rows = new int[rowMax][];
		
		int j = 1;
        for (int i=0; i<rowMax; i++) {
         j = (i*(colMax-1)/(rowMax-1)) + 1;
         rows[i] = new int[j];
        }
	}
	
	public int get(int i, int j) {
		if (i < rowMax && j < rows[i].length) {
			return rows[i][j];
		}
		return -1;
	}
	
	public void put(int i, int j, int value) {
		if (i < rowMax && j < rows[i].length) {
			rows[i][j] = value;
		}
	}
	
	public void init(int[] data) {
		int current = 0;
		for (int i = 0; i < rowMax; i++) {
			for (int j = 0; j < rows[i].length; j++) {
				if (current < data.length) rows[i][j] = data[current++];
			}
		}
	}
	
	public int[] linear() {
		int size = 0;
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[i].length; j++) size++;
		}
		int[] elements = new int[size];
		int current = 0;
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[i].length; j++) elements[current++] = rows[i][j];
		}
		return elements;
	}
	
	public void add(Triangle t){
		for (int i = 0; i < t.rowMax && i < rowMax; i++) {
			for (int j = 0; j < t.rows[i].length && j < rows[i].length; j++)
				rows[i][j] += t.rows[i][j];
		}
	}
	
	public String toString() {
		   String tmp = "";
		   for (int i = 0; i<rowMax; i++) {
			   tmp = tmp + Arrays.toString(rows[i]) + " \n";
		   }
		   return tmp;
	   }
}
