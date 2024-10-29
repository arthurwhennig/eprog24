package Counting;

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

		System.out.println(containsSubstringAt("", 0, ""));
	}
	
	public static boolean containsSubstringAt(String str, int position, String sub) {
		// check range for edge cases
		if (position < 0 || position >= str.length()) return false;
		// go through each character in sub and compare with corresponding character from str
		for (int i = 0; i < sub.length(); i++) {
			if (str.charAt(position + i) != sub.charAt(i)) return false;
		}
		return true;
	}
	
	public static int countSubstrings(String str, String sub) {
		int count = 0;
		// go through str and apply containsSubstringAt for each i inside of bounds
		for (int i = 0; i <= str.length() - sub.length(); i++) {
			if (containsSubstringAt(str, i, sub)) count++;
		}
		return count;
	}
	
	public static int countDisjointSubstrings(String str, String sub) {
		int count = 0;
		// go through str and apply containsSubstringAt for each i inside of bounds and move i to the right
		for (int i = 0; i <= str.length() - sub.length(); i++) {
			if (containsSubstringAt(str, i, sub)) {
				count++;
				i += sub.length()-1;
			};
		}
		return count;
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
