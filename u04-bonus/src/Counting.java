public class Counting {

	public static void main(String[] args) {
		testContainsSubstringAt(true,  "abcd", 0, "ab");
		testContainsSubstringAt(false, "abcd", 1, "ab"); 
		testContainsSubstringAt(false, "abcd", 4, "ab");
		testContainsSubstringAt(false, "abcd", -1, "ab");
		
		testCountSubstrings(2, "aaa", "aa"); 
		testCountSubstrings(3, "aaaa", "aa");
		testCountSubstrings(2, "12341234123", "123412");
		
		testCountDisjointSubstrings(1, "abcdcba", "abc");
		testCountDisjointSubstrings(2, "abcdcba", "c");
		testCountDisjointSubstrings(2, "0101010", "010");
	}
	
	public static boolean containsSubstringAt(String str, int position, String sub) {
		// TODO
		return false; 
	}
	
	public static int countSubstrings(String str, String sub) {
		// TODO
		return -1; 
	}
	
	public static int countDisjointSubstrings(String str, String sub) {
		// TODO
		return -1; 
	}
	
	public static void testContainsSubstringAt(boolean expected, String str, int position, String sub) {
		boolean result = containsSubstringAt(str, position, sub);
		if (expected == result) {
			System.out.println("Passed.");
		} else {
			System.out.println("Failed. Check substring " + sub +  " in string " + str + " at position " + position + ", expected " + expected + ", but got " + result + ".");
		}
	}
	
	public static void testCountSubstrings(int expected, String str, String sub) {
		int result = countSubstrings(str, sub);
		if (expected == result) {
			System.out.println("Passed.");
		} else {
			System.out.println("Failed. Count substring " + sub +  "\t in String " + str + ",\t expected " + expected + ", but got " + result + ".");
		}
	}
	
	public static void testCountDisjointSubstrings(int expected, String str, String sub) {
		int result = countDisjointSubstrings(str, sub);
		if (expected == result) {
			System.out.println("Passed.");
		} else {
			System.out.println("Failed. Count substring " + sub +  "\t disjoint appearances in String " + str + " \t expected " + expected + ", but got " + result + ".");
		}
	}

}
