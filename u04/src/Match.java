public class Match {

	public static void main(String[] args) {
		testMatchNumber(1, 32857890, 789);
		testMatchNumber(1, 37897890, 789);
		testMatchNumber(2, 1800765, 7);
		testMatchNumber(-1, 1800765, 8);
		testMatchNumber(1, 75, 7);
	}
	
	public static void testMatchNumber(int expected, long A, int M) {
		int result = matchNumber(A, M);
		if (expected == result) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed. Expected " + expected + ", but got " + result + ".");
		}
	}
	
	public static int matchNumber(long A, int M) {
		// append three 0s to the left of A (which has size Math.log10(A) + 1)
		int size = (int) Math.log10(A) + 4;
		int[] ADigits = new int[size];
		int[] MDigits = new int[3];
		// fill up both digit arrays
		for (int i = MDigits.length-1; i >= 0; i--) {
			int lastDigit = M % 10;
			MDigits[i] = lastDigit;
			M /= 10;
		}
		for (int i = ADigits.length-1; i >= 0; i--) {
			int lastDigit = (int) (A % 10);
			ADigits[i] = lastDigit;
			A /= 10;
		}
		// scan through the digit array of A and look for a match with M
		for (int idx = ADigits.length-1; idx >= 2; idx--) {
			int first = ADigits[idx], second = ADigits[idx-1], third = ADigits[idx-2];
			if (first == MDigits[2] && second == MDigits[1] && third == MDigits[0]) return ADigits.length-1-idx;
		}
		return -1;
	}

}
