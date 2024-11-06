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
		for (int i = 0; i < rowMax; i++) {
			j = (i * (colMax - 1) / (rowMax - 1)) + 1;
			rows[i] = new int[j];
		}
	}

	public int get(int i, int j) {

		if (rows.length > i && rows[i].length > j)
			return rows[i][j];
		else
			return 0; // return 0 such that one can use the get method in Add
	}

	public void put(int i, int j, int value) {
		rows[i][j] = value;
	}

	public void init(int[] data) {
		int i = 0;
		for (int row = 0; row < rows.length; row++) {
			for (int element = 0; element < rows[row].length; element++) {
				put(row, element, data[i]);
				i++;
			}
		}
	}

	// returns all the elements in an array in order
	public int[] linear() {
		int[] result = new int[amountOfElements()];
		int i = 0;
		for (int[] row : rows) {
			for (int element : row) {
				result[i] = element;
				i++;
			}
		}
		return result;
	}

	public void add(Triangle t) {
		for (int row = 0; row < rows.length; row++) {
			for (int element = 0; element < rows[row].length; element++) {
				// works, because get return 0 if we run out of bounds.
				rows[row][element] += t.get(row, element);
			}
		}
	}

	// returns the amount of elements in the matrix
	public int amountOfElements() {
		int amount = 0;
		for (int i = 0; i < rows.length; i++) {
			amount += rows[i].length;
		}
		return amount;
	}

	public String toString() {
		String tmp = "";
		for (int i = 0; i < rowMax; i++) {
			tmp = tmp + Arrays.toString(rows[i]) + " \n";
		}
		return tmp;
	}
}
