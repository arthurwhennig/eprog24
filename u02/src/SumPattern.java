import java.util.Scanner;


// die Aufgabenstellung war etwas anders gemeint, guck mal in die Musterlösung, ansonsten gut :)


public class SumPattern {
	public static void main(String[] args) {
		// Aendern Sie die Werte um verschiedene Ausfuehrungen zu testen.
		Scanner myConsole = new Scanner(System.in);

		int a = retrieveInt("Geben Sie a ein:", myConsole);
		int b = retrieveInt("Geben Sie b ein:", myConsole);
		int c = retrieveInt("Geben Sie c ein:", myConsole);
		
		// Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		if (a + c == b) {
			System.out.println("Moeglich. " + a + " + " + c + " == " + b);
		} else {
			System.out.println("Unmoeglich.");
		}
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
