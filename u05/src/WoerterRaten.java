import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class WoerterRaten {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("woerter.txt"));
        String[] woerter = liesWoerter(scanner);
        scanner.close();
        
        rateSpiel(woerter);
    }
    
    /**
     * Liest die Wörter von dem gegebenen Scanner ein und gibt sie als Array zurück.
     */
    static String[] liesWoerter(Scanner scanner) {
        String[] woerter = new String[scanner.nextInt()];
        for(int i = 0; i < woerter.length; i++) {
            woerter[i] = scanner.next();
        }
        return woerter;
    }
    
    /**
     * Führt das Rate-Spiel einmal durch.
     */
    static void rateSpiel(String[] woerter) {
        Scanner myConsole = new Scanner(System.in);
        String wort = zufallsWort(woerter);
        String hinweis = "";
        int count = 0;

        while (!hinweis.equals("ist")) {
            System.out.println("Tipp?");
            String tipp = myConsole.nextLine();
            hinweis = hinweis(wort, tipp);
            System.out.println("Das Wort " + hinweis + " \"" + tipp + "\"!");
            count++;
        }

        System.out.println("Glückwunsch! Sie haben das Wort in nur " + count + (count == 1 ? " Frage" : " Fragen") + " erraten!");
    }
    
    /**
     * Wählt zufällig ein Wort aus dem "woerter"-Array aus und gibt es zurück.
     */
    static String zufallsWort(String[] woerter) {
        int idx = new Random().nextInt(woerter.length);
        return woerter[idx];
    }
    
    /**
     * Vergleicht das gegebene "wort" und die "tipp"-Zeichenkette und gibt einen Hinweis zurück.
     * Folgende Hinweise sind möglich: "ist", "beginnt mit", "endet mit", "beginnt mit und endet
     * mit", "enthält" oder "enthält nicht".
     */
    static String hinweis(String wort, String tipp) {
        if (wort.equals(tipp)) return "ist";
        if (wort.startsWith(tipp) && wort.endsWith(tipp)) return "beginnt mit und endet mit";
        if (wort.startsWith(tipp)) return "beginnt mit";
        if (wort.endsWith(tipp)) return "endet mit";
        if (wort.contains(tipp)) return "enthält";
        return "enthält nicht";
    }
}