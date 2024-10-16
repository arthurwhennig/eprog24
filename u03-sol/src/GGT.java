import java.util.Scanner;

/*
 * Dieses Programm berechnet den GGT von zwei ganzen Zahlen.
 */
public class GGT {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Geben Sie zwei positive ganze Zahlen ein: ");
		
		//Input aus Konsole einlesen
		int x = console.nextInt();
		int y = console.nextInt();
		

		//Überprüfen, ob beide Iputs positiv sind
		if (x <= 0 || y <= 0) {
			System.out.println("Keine positiven ganzen Zahlen!");
		} else { //berechnung von GGT x und y
			while (x <= y || x % y != 0) { //solange x kleiner als y oder x sich nicht durch y teilen lässt:
				//GGT noch nicht gefunden
				//update x und y für nächste Iteration
				
				int altY = y; // Zwischenspeichern von y
				
				y = x % y;
				x = altY;
			}

			//GGT gefunden (x >= y && x % y == 0)
			System.out.println(y);
		}
	}
}
