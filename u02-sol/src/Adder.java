import java.util.Scanner; // Importiert Scanner-Klasse


public class Adder {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		// Erster Prompt
		System.out.println("Geben Sie Zahl 1 ein:");
		
		// User Input einlesen
		int zahl1 = console.nextInt();
		
		// Zweiter Prompt
		System.out.println("Geben Sie Zahl 2 ein:");
		
		// User Input einlesen
		int zahl2 = console.nextInt();
		
		// Resultat berechnen
		int resultat = zahl1 + zahl2;
		
		// Finaler Output
		System.out.println(zahl1 + " + " + zahl2 + " = " + resultat);
	}

}
