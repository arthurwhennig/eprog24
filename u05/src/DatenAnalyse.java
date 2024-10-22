import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        return new int[0];
    }
    
    /**
     * Macht eine einfache Datenanalyse: Gibt die Anzahl Daten, das Minimum, das Maximum und den
     * Durchschnitt der Kelchblattlängen aus.
     */
    static void einfacheAnalyse(int[] laengen) {
    }
    
    /**
     * Erstellt ein Histogramm der Kelchblattlängen und gibt es aus. Zuerst wird der Benutzer nach der
     * Anzahl Histogramm-Klassen gefragt.
     */
    static void histogrammAnalyse(int[] laengen, int histMin, int histMax) {
    }
    
    /**
     * Erstellt von den Kelchblattlängen in dem "laengen"-Array ein Histogramm mit den gegebenen
     * Grössen Minimum, Maximum und Anzahl Klassen.
     * 
     * @return das Histogramm, als Array. Jedes Element entspricht einer Klasse im Histogramm und
     *         enthält die Anzahl Kelchblattlängen in dieser Klasse.
     */
    static int[] erstelleHistogramm(int[] laengen, int histMin, int histMax, int klassen) {
        return new int[0];
    }
    
    /**
     * Gibt die Klassenbreite in einem Histogramm mit den gegebenen Grössen Minimum, Maximum und
     * Anzahl Klassen zurück. Falls sich die gesamte Breite des Histogramms nicht restlos auf die
     * Klassen aufteilen lässt, wird die Klassenbreite aufgerundet. Das heisst, dass das Histogramm
     * "histMax" überschreiten kann.
     */
    static int klassenBreite(int histMin, int histMax, int klassen) {
        return 0;
    }
}