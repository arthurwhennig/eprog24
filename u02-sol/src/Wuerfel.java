import java.util.Scanner; // Scanner Klasse
import java.util.Random;  // Random Klasse


public class Wuerfel {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		Random rand = new Random();
		
		// Erster User Prompt
		System.out.println("Wie viele Seiten hat Ihr Würfel?");
		
		// User Input einlesen
		int seiten = console.nextInt();
		
		// Würfelwurf simulieren - zweites argument exklusive bei ranges in Java
		int zahl = rand.nextInt(1, seiten + 1);
 
		// Resultat ausgeben
		System.out.println("Es wurde eine " + zahl + " gewürfelt!");
	}

}
