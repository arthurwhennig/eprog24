import java.util.Scanner;

/*
 * Dieses Programm gibt die Binaerdarstellung einer positiven Zahl aus, ohne Arrays oder String-
 * Operationen.
 */
public class Binaer {

	public static void main(String[] args) {
		Scanner myConsole = new Scanner(System.in);
		int num = retrieveInt("Enter a number:", myConsole);

		printBinary(num);
	}

	public static int retrieveInt(String msg, Scanner input) {
		System.out.println(msg);
		try {
			return Integer.parseInt(input.nextLine());
		} catch (NumberFormatException e) {
			return retrieveInt("Please enter a valid number.", input);
		}
	}

	public static void printBinary(int num) {
		if (num <= 0) return;
		printBinary(num/2);
		System.out.print(num%2);
	}
}
