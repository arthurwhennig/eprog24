import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class BlackBoxTest {

	@Test
	public void testRotateArray() {
	    int[] values = new int[] { 1, 2 };
		int[] expected = new int[] { 2, 1 };
		BlackBox.rotateArray(values, 1);
		assertArrayEquals(expected, values);
		
		values = new int[] { 3, 4, -1, 2, 5, -6, 9, 0 };
		expected = new int[] { 2, 5, -6, 9, 0, 3, 4, -1 };
		BlackBox.rotateArray(values, -3);
		assertArrayEquals(expected, values);
		
		values = new int[] { 10 };
		expected = new int[] { 10 };
		BlackBox.rotateArray(values, 5);
		assertArrayEquals(expected, values);
		
		values = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		expected = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		BlackBox.rotateArray(values, 10);
		assertArrayEquals(expected, values);
 	}
}
