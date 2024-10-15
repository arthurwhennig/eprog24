import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CountingTest {

	@Test
	public void testContainsSubstringAt() {
		assertEquals(true,  Counting.containsSubstringAt("abcd", 0, "ab"));
		assertEquals(false, Counting.containsSubstringAt("abcd", 1, "ab"));
		assertEquals(false, Counting.containsSubstringAt("abcd", 4, "ab"));
		assertEquals(false, Counting.containsSubstringAt("abcd", -1, "ab"));
	}
	
	@Test
	public void testCountSubstrings() {
		assertEquals(2, Counting.countSubstrings("aaa", "aa"));
		assertEquals(3, Counting.countSubstrings("aaaa", "aa"));
		assertEquals(2, Counting.countSubstrings("12341234123", "123412"));
	}
	
	@Test
	public void testCountDisjointSubstrings() {
		assertEquals(1, Counting.countDisjointSubstrings("abcdcba", "abc"));
		assertEquals(2, Counting.countDisjointSubstrings("abcdcba", "c"));
		assertEquals(2, Counting.countDisjointSubstrings("0101010", "010"));
	}
	
}
