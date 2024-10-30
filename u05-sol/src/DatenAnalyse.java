import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 
 * Analysiert einen Datensatz von Kelchblattlängen.
 */
public class DatenAnalyse {
        
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("sepal_length_setosa.txt"));
        int[] laengen = liesLaengen(scanner);
        scanner.close();
        
        einfacheAnalyse(laengen);
        
        int histMin = 40; //  Wir nehmen an, dass alle Laengen >= 40mm sind
        int histMax = 80; //  Wir nehmen an, dass alle Laengen < 80mm sind
        histogrammAnalyse(laengen, histMin, histMax);
    }
    
    /**
     * Liest die Kelchblattlängen von dem gegebenen Scanner ein und gibt sie als Array zurück.
     */
    static int[] liesLaengen(Scanner scanner) {
        int[] laengen = new int[scanner.nextInt()];
        for(int i = 0; i < laengen.length; i++) {
            laengen[i] = scanner.nextInt(); 
        }
        return laengen;
    }
    
    /**
     * Macht eine einfache Datenanalyse: Gibt die Anzahl Daten, das Minimum, das Maximum und den
     * Durchschnitt der Kelchblattlängen aus.
     */
    static void einfacheAnalyse(int[] laengen) {
        int min = Integer.MAX_VALUE, max = 0, sum = 0;
        for(int i = 0; i < laengen.length; i++) {
            min = Math.min(min, laengen[i]);
            max = Math.max(max, laengen[i]);
            sum += laengen[i];
        }
        
        int durchschnitt = sum / laengen.length;
        System.out.println("Anzahl Daten: " + laengen.length);
        System.out.println("Minimum: " + min + " mm");
        System.out.println("Maximum: " + max + " mm");
        System.out.println("Durchschnitt: " + durchschnitt + " mm");
        System.out.println();
    }
    
    /**
     * Erstellt ein Histogramm der Kelchblattlängen und gibt es aus. Zuerst wird der Benutzer nach der
     * Anzahl Histogramm-Klassen gefragt.
     */
    static void histogrammAnalyse(int[] laengen, int histMin, int histMax) {
        System.out.print("Wie viele Klassen soll das Histogramm enthalten? ");
        int klassen = new Scanner(System.in).nextInt();
        if(klassen <= 0) {
            System.out.println("Ungültige Anzahl Klassen!");
        }
        else {
            int[] histogramm = erstelleHistogramm(laengen, histMin, histMax, klassen);
            druckeHistogramm(histogramm, histMin, histMax);
        }
    }
    
    /**
     * Erstellt von den Kelchblattlängen in dem "laengen"-Array ein Histogramm mit den gegebenen
     * Grössen Minimum, Maximum und Anzahl Klassen.
     * 
     * @return das Histogramm, als Array. Jedes Element entspricht einer Klasse im Histogramm und
     *         enthält die Anzahl Kelchblattlängen in dieser Klasse.
     */
    static int[] erstelleHistogramm(int[] laengen, int histMin, int histMax, int klassen) {
        int klassenBreite = klassenBreite(histMin, histMax, klassen);
        int[] histogramm = new int[klassen];
        for(int i = 0; i < laengen.length; i++) {
            int klasse = klasseFuerLaenge(laengen[i], histMin, klassenBreite);
            histogramm[klasse]++;
        }
        
        return histogramm;
    }
    
    /**
     * Ordnet einer gegebenen Körpergrösse eine Klasse in einem Histogramm, welches durch "histMin"
     * und "klassenBreite" gegeben ist, zu.
     */
    static int klasseFuerLaenge(int groesse, int histMin, int klassenBreite) {
        return (groesse - histMin) / klassenBreite;
    }
    
    /**
     * Gibt das gegebene Histogramm als Text-Diagramm aus.
     */
    static void druckeHistogramm(int[] histogramm, int histMin, int histMax) {
        int klassenBreite = klassenBreite(histMin, histMax, histogramm.length);
        for(int k = 0; k < histogramm.length; k++) {
            System.out.print(klassenBeschreibung(k, histMin, klassenBreite) + " ");
            for(int i = 0; i < histogramm[k]; i++)
                System.out.print("|");
            System.out.println();
        }
    }
    
    /**
     * Gibt für die gegebene "klasse" und für das Histogramm, welches durch "histMin" und
     * "klassenBreite" gegeben ist, eine Beschreibung zurück.
     */
    static String klassenBeschreibung(int klasse, int histMin, int klassenBreite) {
        int untereGrenze = histMin + klasse * klassenBreite;
        int obereGrenze = untereGrenze + klassenBreite;
        return "[" + untereGrenze + "," + obereGrenze + ")";
    }
    
    /**
     * Gibt die Klassenbreite in einem Histogramm mit den gegebenen Grössen Minimum, Maximum und
     * Anzahl Klassen zurück. Falls sich die gesamte Breite des Histogramms nicht restlos auf die
     * Klassen aufteilen lässt, wird die Klassenbreite aufgerundet. Das heisst, dass das Histogramm
     * "histMax" überschreiten kann.
     */
    static int klassenBreite(int histMin, int histMax, int klassen) {
        int histBreite = histMax - histMin;
        int klassenBreite = histBreite / klassen;
        if(histBreite % klassen != 0)
            klassenBreite++; // Falls Division nicht aufgeht, mache Klassen etwas "zu breit"
            
        return klassenBreite;
    }
}
