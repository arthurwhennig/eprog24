import java.util.Arrays;

public class Minesweeper {

	public static void main(String[] args) {
		int[][] board = {
				{-1, -1, -2, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -2, -1},
		};
		
		int count = computeMineCount(board, 1, 1);
		System.out.println(count);
		
		gameTurn(board, 2, 1);
		System.out.println(Arrays.deepToString(board));
		
		revealAllMines(board);
		System.out.println(Arrays.deepToString(board));
	}
	
	public static void revealAllMines(int[][] board) {
		// update all mine fields to a 9
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == -2) board[row][col] = 9;
			}
		}
		
	}
	
	public static int computeMineCount(int[][] board, int row, int col) {
		// check if the indices are in bounds
		if (row < 0 || row >= board.length || col < 0 || col >= board.length) return -1;
		// reveal a mine
		if (board[row][col] == -2) return 9;
		int count = 0;
		// count the number of mines in all neighboring fields
		for (int i = (row > 0 ? row-1 : 0); i <= row+1 && i < board.length; i++) {
			for (int j = (col > 0 ? col-1 : 0); j <= col+1 && j < board[i].length; j++) {
				if (board[i][j] == -2) count++;
			}
		}
		return count;
	}
	
	public static void gameTurn(int[][] board, int row, int col) {
		// check if the indices are in bounds
		if (row < 0 || col < 0 || row >= board.length || col >= board.length) return;
		// skip an already revealed field
		if (board[row][col] >= 0) return;
		int count = computeMineCount(board, row, col);
		// game over for mine
		if (count == 9) {
			revealAllMines(board);
			return;
		}
		// mark the field as revealed
		board[row][col] = count;
		if (count == 0) {
			// perform gameTurn recursively on all neighboring fields
			for (int i = row-1; i <= row+1; i++) {
				for (int j = col-1; j <= col+1; j++) gameTurn(board, i, j);
			}
		}
	}
	
}
