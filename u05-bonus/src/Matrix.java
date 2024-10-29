public class Matrix {

    public static int countAssimilated(int[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (isAssimilated(matrix, row, col)) count++;
            }
        }
        return count;
    }

    public static boolean isAssimilated(int[][] matrix, int row, int col) {
        int above = row-1, below = row+1;
        int left = col-1, right = col+1;
        int[] neighbors = new int[8];
        if (above >= 0) {
            neighbors[1] = matrix[above][col];
            if (left >= 0) neighbors[0] = matrix[above][left];
            if (right < matrix[row].length) neighbors[2] = matrix[above][right];
        }
        if (below < matrix.length) {
            neighbors[6] = matrix[below][col];
            if (left >= 0) neighbors[5] = matrix[below][left];
            if (right < matrix[row].length) neighbors[7] = matrix[below][right];
        }
        if (left >= 0) neighbors[3] = matrix[row][left];
        if (right < matrix[row].length) neighbors[4] = matrix[row][right];
        int sum = 0;
        for (int neighbor : neighbors) sum += neighbor;
        return sum % matrix[row][col] == 0;
    }

    public static void main(String[] args) {
        System.out.println("countAssimilated([[10, 10, 10], [10, 10, 10], [10, 10, 10]]): " +
                countAssimilated(new int[][]{{10, 10, 10}, {10, 10, 10}, {10, 10, 10}}));
        System.out.println("countAssimilated([[5, 10, 3], [6, 9, 6], [3, 3, 15]]): " +
                countAssimilated(new int[][]{{5, 10, 3}, {6, 9, 6}, {3, 3, 15}}));
        System.out.println("countAssimilated([[4, 7, 13], [-2, -12, 32], [20, 15, -8], [17, 3, 1111]]): " +
                countAssimilated(new int[][]{{4, 7, 13}, {-2, -12, 32}, {20, 15, -8}, {17, 3, 1111}}));
        System.out.println("countAssimilated([[1, 2, 3, 4, 5, 6], " +
                "[7, 8, 9, 10, 11, 12], " +
                "[13, 14, 15, 16, 17, 18], " +
                "[19, 20, 21, 22, 23, 24], " +
                "[25, 26, 27, 28, 29, 30]]): " +
                countAssimilated(new int[][]{{1, 2, 3, 4, 5, 6},
                        {7, 8, 9, 10, 11, 12},
                        {13, 14, 15, 16, 17, 18},
                        {19, 20, 21, 22, 23, 24},
                        {25, 26, 27, 28, 29, 30}}));
    }
}
