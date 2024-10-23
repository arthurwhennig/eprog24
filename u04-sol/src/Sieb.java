import java.util.Scanner;

/*
 * Dieses Programm zaehlt die Primzahlen bis zu einem Limit.
 */
public class Sieb {
	
	// Methode zum Initialisieren des Siebes
    public static boolean[] initSieb(int limit) {
        boolean[] sieb = new boolean[limit + 1];
        // Setze alle Elemente ab 2 auf true
        for (int i = 2; i < sieb.length; i++) {
            sieb[i] = true;
        }
        return sieb;
    }

    // Methode zur Berechnung der Primzahlen mit dem Sieb des Eratosthenes
    public static void berechnePrimzahlen(boolean[] sieb, int limit) {
        for (int i = 2; i < limit; i++) {
            if (sieb[i]) {
                // Setze alle Vielfachen von i auf false
                for (int vielfaches = 2 * i; vielfaches <= limit; vielfaches += i) {
                    sieb[vielfaches] = false;
                }
            }
        }
    }

    // Methode zum Zählen der Primzahlen
    public static int zaehlePrimzahlen(boolean[] sieb) {
        int primzahlen = 0;
        // Zähle die verbleibenden Primzahlen
        for (int i = 2; i < sieb.length; i++) {
            if (sieb[i]) {
                primzahlen++;
            }
        }
        return primzahlen;
    }
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine positive ganze Zahl ein: ");
        int limit = scanner.nextInt();

        if(limit <= 0) {
            System.out.println("Keine positive ganze Zahl!");
        } else {
            boolean[] sieb = initSieb(limit);
            berechnePrimzahlen(sieb, limit);
            int primzahlen = zaehlePrimzahlen(sieb);
            System.out.println(primzahlen);
        }
    }

	
    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine positive ganze Zahl ein: ");
        int limit = scanner.nextInt();
        if(limit <= 0) {
            System.out.println("Keine positive ganze Zahl!");
        }
        else {
            // True: "ist Primzahl", false: "ist keine Primzahl"
            boolean[] sieb = new boolean[limit + 1];
            // Setze alle Elemente ab 2 auf true
            for(int i = 2; i < sieb.length; i++)
                sieb[i] = true;
            
            // Gehe alle Zahlen bis limit durch und setze Vielfache davon auf false
            // Zusaetzliche Optimierung waere: statt bis limit nur bis wurzel(limit)
            for(int i = 2; i < limit; i++) {
                // Optimierung: nur, wenn Element nicht schon false ist
                if(sieb[i]) {
                    for (int vielfaches = 2 * i; vielfaches <= limit; vielfaches += i) { 
                        sieb[vielfaches] = false;
                    }
                }
            }
            
            // Zaehle uebrig gebliebene Zahlen - Primzahlen
            int primzahlen = 0;
            for(int i = 2; i < sieb.length; i++)
                if(sieb[i])
                    primzahlen++;
                
            System.out.println(primzahlen);
        }
    }*/
}
