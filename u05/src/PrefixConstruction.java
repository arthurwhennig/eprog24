public class PrefixConstruction {

	public static void main(String[] args) {
		System.out.println(isPrefixConstruction("abac", "abc", 3));
	}

	public static boolean isPrefixConstruction(String s, String t, int n) {
		if (n <= 0) return false;
		for (int i = 0; i < t.length() && i < s.length(); i++) {
			if (t.charAt(i) == s.charAt(i)) {
				if (i == s.length()-1) return true;
                if (isPrefixConstruction(s.substring(i + 1), t, n - 1)) return true;
            } else {
				return false;
			}
		}
		return false;
	}
}