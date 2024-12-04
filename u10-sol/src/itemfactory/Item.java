package itemfactory;
import java.util.ArrayList;

public class Item {

    private Level level; // Die Ebene, zu der dieses Item gehört (z. B. eine Hierarchie oder Struktur).
    private int id; // Eindeutige ID des Items.
    private int age; // Alter des Items (evtl. zur Steuerung von Zuständen oder Lebenszyklen).
    private int health; // Gesundheitswert des Items.
    public boolean isDeclass; // Gibt an, ob das Item deklassiert (Declass) ist.
    public Item target; // Zielobjekt, auf das dieses Item verweist, falls es deklassiert ist.
    public Item directTarget; // Direkte Zielreferenz, falls benötigt (bei Declass).
    public ArrayList<Item> link = new ArrayList<>(); // Liste von verlinkten Items, die miteinander synchronisiert werden.

    // Konstruktor: Initialisiert ein Item mit spezifischem Level, ID, Alter und Gesundheitswert.
    public Item(Level level, int id, int age, int health) {
        this.level = level; // Das Level (Kontext) des Items setzen.
        this.id = id; // Eindeutige ID des Items setzen.
        this.age = age; // Alter des Items setzen.
        this.health = health; // Gesundheitswert setzen.
    }

    // Getter für das Level des Items.
    public Level getLevel() {
        return level;
    }

    // Getter für die ID des Items.
    public int getID() {
        return id;
    }

    // Getter für das Alter des Items. Falls deklassiert, wird das Alter des Zielobjekts zurückgegeben.
    public int getAge() {
        if (isDeclass) { // Prüfen, ob das Item deklassiert ist.
            return target.getAge(); // Alter des Zielobjekts zurückgeben.
        }
        return age; // Ansonsten das eigene Alter zurückgeben.
    }

    // Getter für die Gesundheit des Items. Falls deklassiert, wird die Gesundheit des Zielobjekts zurückgegeben.
    public int getHealth() {
        if (isDeclass) { // Prüfen, ob das Item deklassiert ist.
            return target.getHealth(); // Gesundheit des Zielobjekts zurückgeben.
        }
        return health; // Ansonsten die eigene Gesundheit zurückgeben.
    }

    // Setter für die Gesundheit des Items. Synchronisiert auch die Gesundheit verlinkter Items.
    public void setHealth(int newHealth) {
        if (health == newHealth) return; // Abbruch, falls die Gesundheit sich nicht ändert.
        health = newHealth; // Neue Gesundheit setzen.
        for (Item item : link) { // Über alle verlinkten Items iterieren.
            item.setHealth(newHealth); // Gesundheit der verlinkten Items synchronisieren.
        }
    }
}
