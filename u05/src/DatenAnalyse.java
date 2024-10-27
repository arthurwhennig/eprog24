import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DatenAnalyse {
    
    public static void main(String[] args) throws FileNotFoundException {
        String[] filenames = new String[]{"sepal_length_setosa.txt", "sepal_length_versicolor.txt", "sepal_length_virginica.txt"};
        int histMin = 40; //  Wir nehmen an, dass alle Laengen >= 40mm sind
        int histMax = 80; //  Wir nehmen an, dass alle Laengen < 80mm sind

        for (String filename : filenames) {
            Scanner scanner = new Scanner(new File(filename));
            int[] laengen = liesLaengen(scanner);
            System.out.println(filename);
            einfacheAnalyse(laengen);
            histogrammAnalyse(laengen, histMin, histMax);
            scanner.close();
        }
    }
    
    /**
     * Liest die Kelchblattlängen von dem gegebenen Scanner ein und gibt sie als Array zurück.
     */
    static int[] liesLaengen(Scanner scanner) {
        int[] laengen = new int[scanner.nextInt()];
        for (int i = 0; i < laengen.length; i++) {
            laengen[i] = scanner.nextInt();
        }
        return laengen;
    }
    
    /**
     * Macht eine einfache Datenanalyse: Gibt die Anzahl Daten, das Minimum, das Maximum und den
     * Durchschnitt der Kelchblattlängen aus.
     */
    static void einfacheAnalyse(int[] laengen) {
        int min = 80;
        int max = 40;
        int sum = 0;
        for (int laenge : laengen) {
            min = Math.min(laenge, min);
            max = Math.max(laenge, max);
            sum += laenge;
        }
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Durchschnitt: " + (sum/laengen.length));
    }
    
    /**
     * Erstellt ein Histogramm der Kelchblattlängen und gibt es aus. Zuerst wird der Benutzer nach der
     * Anzahl Histogramm-Klassen gefragt.
     */
    static void histogrammAnalyse(int[] laengen, int histMin, int histMax) {
        Scanner myConsole = new Scanner(System.in);
        System.out.println("Wie viele Klassen?");
        int klassen = myConsole.nextInt();

        int[] histogramm = erstelleHistogramm(laengen, histMin, histMax, klassen);
        int breite = klassenBreite(histMin, histMax, klassen);

        for (int i = 0; i < histogramm.length; i++) {
            System.out.print("[" + (histMin + i * breite) + "," + (histMin + (i+1) * breite) + ")  ");
            for (int j = 0; j < histogramm[i]; j++) {
                System.out.print("|");
            }
            System.out.println();
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
        int breite = klassenBreite(histMin, histMax, klassen);
        int[] histogramm = new int[klassen];
        for (int laenge : laengen) {
            int classIdx = (laenge - histMin) / breite;
            histogramm[classIdx]++;
        }

        return histogramm;
    }
    
    /**
     * Gibt die Klassenbreite in einem Histogramm mit den gegebenen Grössen Minimum, Maximum und
     * Anzahl Klassen zurück. Falls sich die gesamte Breite des Histogramms nicht restlos auf die
     * Klassen aufteilen lässt, wird die Klassenbreite aufgerundet. Das heisst, dass das Histogramm
     * "histMax" überschreiten kann.
     */
    static int klassenBreite(int histMin, int histMax, int klassen) {
        int range = histMax - histMin;
        if (range % klassen == 0) return range / klassen;
        return range / klassen + 1;
    }
}