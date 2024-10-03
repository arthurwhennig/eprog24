import java.util.Scanner;

public class AbsoluteMax {
	
	public static void main(String[] args) {
		// Aendern Sie die Werte um verschiedene Ausfuehrungen zu testen.
		Scanner myConsole = new Scanner(System.in);

		int a = retrieveInt("Geben Sie a ein:", myConsole);
		int b = retrieveInt("Geben Sie b ein:", myConsole);
		int c = retrieveInt("Geben Sie c ein:", myConsole);
		
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben

		// take the absolute values of a, b, c
		if (a < 0) {
			a = -a;
		}
		if (b < 0) {
			b = -b;
		}
		if (c < 0) {
			c = -c;
		}

		int r = -1;

		// take the maximum of abs(a), abs(b) and abs(c)
		if (a > b && a > c) {
			r = a;
		} else if (b > a && b > c) {
			r = b;
		} else {
			r = c;
		}
		
		// Der finale Wert von r wird ausgegeben
		System.out.println("a: " + a + ", b: " + b + ", c: " + c + " --> r: " + r);
	}

	public static int retrieveInt(String msg, Scanner input) {
		System.out.println(msg);
		try {
			String line = input.nextLine();
			return Integer.parseInt(line);
		} catch (NumberFormatException e) {
			return retrieveInt("Bitte geben Sie eine valide Zahl ein.", input);
		}
	}
}
