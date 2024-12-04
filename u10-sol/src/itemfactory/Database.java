package itemfactory;

import java.util.ArrayList;
import java.util.List;

public class Database { // Eine Datenbank-Klasse zur Verwaltung von Items und ihrer Verknüpfungen.

    private List<Item> items = new ArrayList<>(); // Liste zur Speicherung aller Items in der Datenbank.
    private ItemFactory factory; // Fabrik zum Erstellen neuer Items, die mit der Datenbank verknüpft ist.

    // Konstruktor: Initialisiert die Datenbank und verbindet sie mit einer ItemFactory.
    public Database() {
        factory = new ItemFactory(); // Eine neue ItemFactory erstellen.
        factory.database = this; // Die Datenbank in der Fabrik referenzieren.
    }

    // Fügt ein Item zur Datenbank hinzu.
    public void add(Item item) {
        items.add(item); // Das übergebene Item zur Liste hinzufügen.
    }

    // Gibt eine Kopie der Item-Liste zurück, um die originale Liste vor Änderungen zu schützen.
    public List<Item> getItems() {
        return new ArrayList<>(items); // Kopie der Liste erstellen und zurückgeben.
    }

    // Gibt die mit der Datenbank verknüpfte ItemFactory zurück.
    public ItemFactory getItemFactory() {
        return factory;
    }

    // Erstellt eine Verknüpfung (Link) zwischen Items basierend auf deren IDs.
    public void createLink(List<Integer> ids) {
        List<Item> linkedItems = new ArrayList<>(); // Liste für die zu verknüpfenden Items.
        for (int id : ids) { // Über die übergebenen IDs iterieren.
            boolean added = false; // Flag, ob ein Item zur Liste hinzugefügt wurde.
            for (Item item : items) { // Alle Items in der Datenbank durchsuchen.
                if (item.getID() == id) { // Wenn die ID übereinstimmt:
                    added = true; // Markieren, dass das Item hinzugefügt wird.
                    linkedItems.add(item); // Item zur Liste hinzufügen.
                }
            }
            if (!added) // Wenn keine Übereinstimmung gefunden wurde:
                throw new IllegalArgumentException("List contains items, that are not in the Database");
                // Ausnahme werfen, da eine ungültige ID übergeben wurde.
        }
        // Verknüpfungen zwischen den gefundenen Items herstellen.
        for (Item item : linkedItems) { 
            item.link.addAll(linkedItems); // Alle verknüpften Items zu jedem Item hinzufügen.
        }
    }
}
