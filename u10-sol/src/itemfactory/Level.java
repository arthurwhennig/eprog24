package itemfactory;
import java.util.ArrayList;
import java.util.List;

public class Level {

    private List<Integer> points; // Liste der Punkte, die das Level definieren.

    // Konstruktor: Initialisiert das Level mit einer Liste von Punkten.
    public Level(List<Integer> points) {
        this.points = new ArrayList<>(points); // Kopiert die übergebene Liste, um Mutationen zu vermeiden.
    }

    // Gibt eine Kopie der Punkte-Liste zurück, um die originale Liste vor Änderungen zu schützen.
    public List<Integer> getPoints() {
        return new ArrayList<>(points); // Neue Liste basierend auf der internen erstellen und zurückgeben.
    }

    // Berechnet die Summe aller Punkte im Level.
    public int sum() {
        int sum = 0; // Variable zur Speicherung der Summe initialisieren.
        for (int curr : this.getPoints()) { // Über alle Punkte iterieren (Kopie der Punkte abrufen).
            sum += curr; // Aktuellen Punkt zur Summe hinzufügen.
        }
        return sum; // Gesamtsumme zurückgeben.
    }
}
