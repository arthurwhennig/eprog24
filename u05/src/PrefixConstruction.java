public class PrefixConstruction {

	public static void main(String[] args) {
		System.out.println(isPrefixConstruction("abcababc", "abc", 2));
	}

	public static boolean isPrefixConstruction(String s, String t, int n) {
		int length = s.length();
		if (n < 0) return false;
		if (s.isEmpty()) return true;
		int count = 0;
		for (int i = 0; i < t.length() && i < s.length(); i++) {
			if (t.contains(s.substring(length-i, length))) {
				count++;
			}
		}
		if (count == 0) return false;
		return isPrefixConstruction(s.substring(0, count), t, n-1);
	}
}