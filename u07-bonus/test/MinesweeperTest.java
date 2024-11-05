import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinesweeperTest {
	
	@Test
	public void testRevealAllMines() {
		int[][] board = {
				{-1, -1, -2, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -2, -1},
		};
		
		Minesweeper.revealAllMines(board);

		int[][] expected = {
				{-1, -1,  9, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1,  9, -1},
		};
		
		assertArrayEquals(expected, board);
	}
	
	@Test
	public void testComputeMineCount() {
		int[][] boardA = {
				{-1, -1, -2, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -2, -1},
		};
		
		int countA = Minesweeper.computeMineCount(boardA, 1, 1);
		
		assertEquals(1, countA);

		int[][] boardB = {
				{-1, -1, -2, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -2, -1},
		};
		
		int countB = Minesweeper.computeMineCount(boardB, 2, 1);
		
		assertEquals(0, countB);
		
		int[][] boardC = {
				{-1, -1, -2, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -2, -1},
		};
		
		int countC = Minesweeper.computeMineCount(boardC, 4, 3);
		
		assertEquals(9, countC);
	}	
	
	@Test
	public void testGameTurn() {
		int[][] board = {
				{-1, -1, -2, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -2, -1},
		};
		
		Minesweeper.gameTurn(board, 1, 1);
		
		int[][] expectedA = {
				{-1, -1, -2, -1, -1},
				{-1,  1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1},
				{-1, -1, -1, -2, -1},
		};
		
		assertArrayEquals(expectedA, board);

		Minesweeper.gameTurn(board, 2, 1);
		
		int[][] expectedB = {
				{ 0,  1, -2,  1,  0},
				{ 0,  1,  1,  1,  0},
				{ 0,  0,  0,  0,  0},
				{ 0,  0,  1,  1,  1},
				{ 0,  0,  1, -2, -1},
		};
		
		assertArrayEquals(expectedB, board);
		
		Minesweeper.gameTurn(board, 4, 3);
		
		int[][] expectedC = {
				{ 0,  1,  9,  1,  0},
				{ 0,  1,  1,  1,  0},
				{ 0,  0,  0,  0,  0},
				{ 0,  0,  1,  1,  1},
				{ 0,  0,  1,  9, -1},
		};
		
		assertArrayEquals(expectedC, board);
	}
	
}
