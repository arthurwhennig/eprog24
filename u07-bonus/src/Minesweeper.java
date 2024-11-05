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
		
		gameTurn(board, 1, 1);
		System.out.println(Arrays.deepToString(board));
		
		revealAllMines(board);
		System.out.println(Arrays.deepToString(board));
	}
	
	public static void revealAllMines(int[][] board) {
		// TODO
		
		
	}
	
	public static int computeMineCount(int[][] board, int row, int col) {
		// TODO
		
		return -1;
	}
	
	public static void gameTurn(int[][] board, int row, int col) {
		// TODO
		
		
	}
	
}
