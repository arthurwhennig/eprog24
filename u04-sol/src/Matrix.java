public class Matrix {

	/*
	 * This method checks if the entries of m are all positive >0! and smaller or
	 * equal n^2 it returns true if that is the case and false otherwise.
	 */
	public static boolean checkDomain(int[][] m) {
		int n = m.length;
		int powN = n * n;

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (m[i][j] <= 0 || m[i][j] > powN) { // Not positive
					return false;
				}
			}
		}

		return true;
	}

	/*
	 * This method checks if the matrix has only unique entries and returns true if
	 * this is the case and false otherwise
	 */
	public static boolean checkUniqueness(int[][] m) {
		int n = m.length;
		boolean[] contains = new boolean[n * n + 1];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				int entry = m[i][j];
				if (contains[entry]) {
					return false;
				} else {
					contains[entry] = true;
				}
			}
		}

		return true;
	}

	/*
	 * This method checks if the row sums and colums sums are equal for all rows and
	 * columns. It returns true if that is the case and false otherwise.
	 */
	public static boolean checkRowAndColSums(int[][] m) {
		int n = m.length;
		int sum = 0;

		// Check the first row first and set the sum
		for (int i = 0; i < n; ++i) {
			sum += m[0][i];
		}

		int currSumRow;
		int currSumCol;

		// Check row and columns simultaneously
		for (int i = 0; i < n; ++i) {
			currSumRow = 0;
			currSumCol = 0;

			for (int j = 0; j < n; ++j) {
				currSumCol += m[i][j];
				currSumRow += m[j][i];
			}

			if (currSumRow != sum || currSumCol != sum) {
				return false;
			}
		}

		return true;
	}

	/*
	 * This method checks if the matrix is square including the edge cases
	 */
	public static boolean checkDimensions(int[][] m) {
		if (m == null) {
			return false;
		}

		int rows = m.length;

		for (int i = 0; i < rows; ++i) {
			int cols = m[i].length;

			if (rows != cols) {
				return false;
			}
		}
		return true;
	}

	/*
	 * This method get a n x n matrix m as input and checks if the matrix is
	 * perfect: 1. The matrix is square 2. All entries are positive 3. For all
	 * entries m(i, j) we have 0 < m(i, j) <= n^2 4. All row sums and all column
	 * sums are equal
	 * 
	 * The order in which these methods are executed is very important, as they
	 * depend on each others results.
	 */
	public static boolean checkMatrix(int[][] m) {
		if (!checkDimensions(m) || !checkDomain(m) || !checkUniqueness(m) || !checkRowAndColSums(m)) {
			return false;
		}
		return true;
	}
	
	/*
	 * The above function is a completely correct and clean solution for this type of task. 
	 * A solution that combines all the separated steps mentioned above into a single function follows here.
	 */

	public static boolean checkMatrix2(int[][] m) {
		// Check the first conditions
		int[] row_sums = new int[m.length]; // Array to store row sums
		int[] col_sums = new int[m.length]; // Array to store column sums

		// Iterate through each row of the matrix
		for (int i = 0; i < m.length; i++) {
			// Check if the matrix is square
			if (m[i].length != m.length)
				return false; // If not, return false

			// Iterate through each column in the current row
			for (int j = 0; j < m[i].length; j++) {
				// Check if the value is greater than n^2 (n is the number of rows/columns)
				if (m[i][j] > Math.pow(m.length, 2))
					return false; // If yes, return false

				// Add the current value to the corresponding row and column sums
				col_sums[j] += m[i][j];
				row_sums[i] += m[i][j];

				// Check if the current value is already present in the remaining rows and
				// columns
				for (int u = i + 1; u < m.length; u++) { // Check rows below the current row
					for (int v = j + 1; v < m[u].length; v++) { // Check columns to the right of the current column
						if (m[u][v] == m[i][j])
							return false; // If the value is already present, return false
					}
				}
			}
		}

		// Check the second conditions

		// Temporary variables to store the first row and column sums
		int row_temp = row_sums[0];
		int col_temp = col_sums[0];

		// Check if all row and column sums are equal
		for (int i = 0; i < m.length; i++) {
			// If any row or column sum does not match, return false
			if (row_sums[i] != row_temp || col_sums[i] != col_temp)
				return false;
		}

		// If all conditions are satisfied, return true
		return true;
	}
}