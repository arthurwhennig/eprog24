import java.util.Scanner; // Scanner Klasse
import java.util.Random;  // Random Klasse


public class ChatGPT {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		Random rand = new Random();
		
		// User Prompt
		System.out.println("Guten Tag! Ich bin ChatGPT, der beste Chatbot, den es gibt! Wie heissen Sie?");
		
		// User Input einlesen
		String name = console.next();
		
		// User nach Alter fragen
		System.out.println("Sehr erfreut " + name + "! Wie alt sind Sie?");
		
		// User Input einlesen
		int alter = console.nextInt();
		
		// Magische Zahl bestimmen und ausgeben
		int magicNumber = rand.nextInt();
		System.out.println("Mittels dieser Information habe ich Ihre Glückszahl gefunden!" + // so kann man Strings unterteilen
				           " Die Glückszahl lautet " + magicNumber);
		
	}

}
