import java.util.Scanner;
/*
 * Dieses Programm berechnet den GGT von zwei ganzen Zahlen.
 */
public class GGT {

	public static void main(String[] args) {
		Scanner myConsole = new Scanner(System.in);
		int x = retrieveInt("Enter x:", myConsole);
		int y = retrieveInt("Enter y:", myConsole);

		int ggt = findGCD(x, y);
		System.out.println("Their greatest common divisor is " + ggt);
	}

	public static int retrieveInt(String msg, Scanner input) {
		System.out.println(msg);
		try {
			return Integer.parseInt(input.nextLine());
		} catch (NumberFormatException e) {
			return retrieveInt("Please enter a valid integer.", input);
		}
	}

	public static int findGCD(int x, int y) {
		int remainder = x % y;
		if (x >= y && remainder == 0) {
			return y;
		}
		return findGCD(y, remainder);
	}

}
