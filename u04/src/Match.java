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
		// TODO
		return -1; 
	}

}
