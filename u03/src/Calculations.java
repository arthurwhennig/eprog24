
public class Calculations {
	public static boolean magic7(int a, int b) {
        return (a + b) == 7 || a > b && a - b == 7 || a < b && b - a == 7;
    }
	
	public static boolean fast12(int z) {
		int remainder = z % 12;
		return remainder <= 2 || remainder >= 10;
	}
}
