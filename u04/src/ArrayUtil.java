import java.util.Arrays;

public class ArrayUtil {

	public static int[] zeroInsert(int[] x) {
		if (x.length < 2) {
			return x;
		}
		int m = (x.length / 2) - 1;
		// solve the left-hand side of m (inclusive)
		int[] left = zeroInsert(Arrays.copyOfRange(x, 0, m+1));
		// solve the right-hand side of m (exclusive)
		int[] right = zeroInsert(Arrays.copyOfRange(x, m+1, x.length));
		int curr = x[m], next = x[m+1];
		// merge the two arrays with an additional 0 in between
		if ((curr < 0 && next > 0) || (curr > 0 && next < 0)) {
			int[] result = new int[left.length + right.length + 1];
			for (int i = 0; i < result.length; i++) {
				if (i < left.length) result[i] = left[i];
				else if (i == left.length) result[i] = 0;
				else result[i] = right[i-left.length-1];
			}
			return result;
		}
		// merge the two arrays without an additional 0 in between
		int[] result = new int[left.length + right.length];
		for (int i = 0; i < (left.length + right.length); i++) {
			if (i < left.length) result[i] = left[i];
			else result[i] = right[i-left.length];
		}
		return result;
	}
	
	public static boolean tenFollows(int[] x, int index) {
		for (int i = index; i < x.length-1; i++) {
			int curr = x[i], next = x[i+1];
			if (next == curr * 10) return true;
		}
		return false;
	}

	
	public static void main(String[] args) {
		// zeroInsert
		System.out.println("Teilaufgabe 1:");
		System.out.println("zeroInsert([3, 4, 5]): " + Arrays.toString(zeroInsert(new int[]{3, 4, 5})));
		System.out.println("zeroInsert([3, 0, -5]): " + Arrays.toString(zeroInsert(new int[]{3, 0, -5})));
		System.out.println("zeroInsert([-3, 4, 6, 9, -8]): " + Arrays.toString(zeroInsert(new int[]{-3, 4, 6, 9, -8})));

		// tenFollows
		System.out.println("\nTeilaufgabe 2:");
		System.out.println("tenFollows([1, 2, 20], 0): " + tenFollows(new int[] {1, 2, 20}, 0));
		System.out.println("tenFollows([1, 2, 7, 20], 0): " + tenFollows(new int[] {1, 2, 7, 20}, 0));
		System.out.println("tenFollows([3, 30], 0): " + tenFollows(new int[] {3, 30}, 0));
		System.out.println("tenFollows([3], 0): " + tenFollows(new int[] {3}, 0));
		System.out.println("tenFollows([1, 2, 20, 5], 1): " + tenFollows(new int[] {1, 2, 20, 5}, 1));
		System.out.println("tenFollows([1, 2, 20, 5], 2): " + tenFollows(new int[] {1, 2, 20, 5}, 2));
	}
}
