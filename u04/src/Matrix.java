
public class Matrix {

	public static void main(String[] args) {
		int[][] perfect = new int[][]{ {1, 5, 9}, {8, 3, 4}, {6, 7, 2} };

		System.out.println(checkMatrix(perfect));
	}

	static boolean checkMatrix(int [][]m) {
		int rows = m.length;
		if (rows < 1) return false;
		int cols = m[0].length;
		// must be n x n
		if (rows != cols) return false;
		// keep track of all previous
		int[] unique = new int[m[0].length * m.length];
		for (int row = 0; row < m.length; row++) {
			for (int col = 0; col < m.length; col++) {
				if (m[row][col] <= 0 || m[row][col] > rows*rows) return false;
				int index = 0;
				while (unique[index] != 0) {
					if (m[row][col] == unique[index]) return false;
					index++;
				}
				unique[index] = m[row][col];
			}
		}
		// ensure same row sums and same column sums
		int mustSum = 0;
		for (int row = 0; row < rows; row++) {
			int rowSum = 0;
			int colSum = 0;
			for (int col = 0; col < cols; col++) {
				rowSum += unique[row * cols + col];
				colSum += unique[col * cols + row];
			}
			if (row == 0) {
				mustSum = rowSum;
				continue;
			}
			if (rowSum != mustSum || colSum != mustSum) return false;
		}
		return true;
	}
}
