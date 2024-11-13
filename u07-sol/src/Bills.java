import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Bills {

    public static void main(String[] args) throws FileNotFoundException {
        // Definiere den Pfad zur Eingabedatei
        String inputFile = "Data.txt";

        // Initialisiere Scanner für das Lesen der Datei und PrintStream für die Ausgabe
        Scanner input = new Scanner(new File(inputFile));
        PrintStream output = new PrintStream(System.out);

        // Starte die Verarbeitung der Datei
        process(input, output);

        // Schließe den Scanner, um Ressourcen freizugeben
        input.close();
    }

    /**
     * Verarbeitet die Eingabedatei und berechnet die Rechnungen für jeden Kunden.
     * @param input Scanner zum Lesen der Eingabedatei
     * @param output PrintStream zum Ausgeben der Rechnungsergebnisse
     */
    public static void process(Scanner input, PrintStream output) {
        int[] intervallGrenzen = null;
        int[] intervallKosten = null;
        int intervalleAnzahl = 0;

        // Lese alle Datenzeilen und verarbeite entsprechend
        while (input.hasNext()) {
            String read = input.next();

            // Verarbeite Tarifbeschreibung
            if (read.equals("Tarif")) {
                intervalleAnzahl = input.nextInt();
                
                // Initialisiere die Arrays dynamisch basierend auf der Anzahl Intervalle
                intervallGrenzen = new int[intervalleAnzahl];
                intervallKosten = new int[intervalleAnzahl];

                // Lese die Intervallgrenzen und Kosten
                for (int i = 0; i < intervalleAnzahl; i++) {
                    intervallGrenzen[i] = input.nextInt();
                    intervallKosten[i] = input.nextInt();
                }
            } else {
                // Lese Kundendaten: ID und Quartalsverbrauch
                int kundeID = Integer.parseInt(read);
                int[] verbrauch = new int[4];
                for (int i = 0; i < 4; i++) {
                    verbrauch[i] = input.nextInt();
                }

                // Berechne den Gesamtverbrauch und den Rechnungsbetrag
                int gesamtVerbrauch = berechneGesamtverbrauch(verbrauch);
                double rechnung = berechneRechnung(gesamtVerbrauch, intervallGrenzen, intervallKosten, intervalleAnzahl);
                int gerundeteRechnung = (int) Math.round(rechnung);

                // Ausgabe des Kunden-ID und Rechnungsbetrag in Franken
                output.println(kundeID + " " + gerundeteRechnung);
            }
        }
    }

    /**
     * Summiert den Stromverbrauch eines Kunden über alle Quartale.
     * @param verbrauch Array mit den Verbrauchswerten der Quartale
     * @return Gesamtverbrauch in Kilowattstunden
     */
    private static int berechneGesamtverbrauch(int[] verbrauch) {
        int gesamt = 0;
        for (int quartal : verbrauch) {
            gesamt += quartal;
        }
        return gesamt;
    }

    /**
     * Berechnet den Rechnungsbetrag für einen Kunden basierend auf dem Gesamtverbrauch und dem Tarif.
     * Der Betrag wird in Rappen berechnet und in Franken umgerechnet.
     * @param gesamtVerbrauch Gesamtverbrauch des Kunden
     * @param grenzen Array mit den Grenzwerten der Intervalle
     * @param kosten Array mit den Kosten pro Intervall (in Rappen pro Kilowattstunde)
     * @param intervalle Anzahl der vorhandenen Intervalle
     * @return Der berechnete Rechnungsbetrag in Franken (als double-Wert)
     */
    private static double berechneRechnung(int gesamtVerbrauch, int[] grenzen, int[] kosten, int intervalle) {
        int verbrauchRest = gesamtVerbrauch;
        double gesamtKosten = 0;

        // Durchlaufe die Intervalle und wende die passenden Kosten an
        for (int i = 0; i < intervalle; i++) {
            if (verbrauchRest <= 0) break;

            int intervallVerbrauch = Math.min(verbrauchRest, grenzen[i]);
            gesamtKosten += intervallVerbrauch * (kosten[i] / 100.0);  // Umrechnung in Franken
            verbrauchRest -= intervallVerbrauch;
        }

        return gesamtKosten;
    }
}
