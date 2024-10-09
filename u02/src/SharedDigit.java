import java.util.Scanner;

public class SharedDigit {
	public static void main(String[] args) {
		Scanner myConsole = new Scanner(System.in);
		// Aendern Sie die Werte um verschiedene Ausfuehrungen zu testen.
		int a = retrieveInt("Geben Sie a ein:", myConsole);
		int b = retrieveInt("Geben Sie b ein:", myConsole);
		
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		// retrieve the individual digits of a and b
		int a1 = a / 10;
		int a2 = a % 10;
		int b1 = b / 10;
		int b2 = b % 10;

		int r = -1;

		if (a1 == b1 || a1 == b2) {
			r = a1;
		} else if (a2 == b1 || a2 == b2) {
			r = a2;
		}
		
		// richtig

		// Der finale Wert von r wird ausgegeben
		System.out.println("a: " + a + ", b: " + b + " --> r: " + r);
	}

	public static int retrieveInt(String msg, Scanner input) {
		System.out.println(msg);
		try {
			String line = input.nextLine();
			int num = Integer.parseInt(line);
			if (num < 10 || num > 99) {
				return retrieveInt("Bitte geben Sie eine Zahl zwischen 10 und 99 ein.", input);
			}
			return num;
		} catch (NumberFormatException e) {
			return retrieveInt("Bitte geben Sie eine valide Zahl ein.", input);
		}
	}
}
