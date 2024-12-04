package itemfactory;
import java.util.List;

public class ItemFactory {

    Database database; // Referenz auf die Datenbank, um auf gespeicherte Items zuzugreifen.

    // Erstellt ein neues Item mit den gegebenen Eigenschaften.
    public Item createItem(Level level, int id, int age, int health) {
        return new Item(level, id, age, health); // Neues Item erstellen und zurückgeben.
    }

    // Erstellt ein deklassiertes Item (Declass), das auf ein Zielobjekt verweist.
    public Item createDeclass(Level level, int id, int targetId) {
        List<Item> items = database.getItems(); // Alle Items aus der Datenbank abrufen.
        Item targetItem = null; // Ziel-Item, auf das das Declass-Item zeigen soll.
        Item directLink = null; // Direkter Verweis auf das Ziel-Item (falls zutreffend).
        int targetIdNeu = targetId; // Lokale Kopie der Ziel-ID, für mögliche Weiterleitungen.

        // Suche nach dem Ziel-Item in der Datenbank.
        for (int i = 0; i < items.size(); i++) {
            Item curr = items.get(i); // Aktuelles Item aus der Liste.

            if (curr.getID() == targetIdNeu) { // Prüfen, ob die ID mit der gesuchten übereinstimmt.
                if (curr.getLevel().sum() == level.sum()) { 
                    // Sicherstellen, dass Level von Declass und Ziel unterschiedlich sind.
                    throw new IllegalArgumentException("Level des Deklassifikationseintrags und des erreichten Items sind verwandt.");
                }
                if (!curr.isDeclass) { // Wenn das gefundene Item kein Declass ist:
                    targetItem = curr; // Es als Ziel setzen.
                    if (curr.getID() == targetId) directLink = curr; // Direkten Link setzen, falls es das ursprüngliche Ziel ist.
                    break; // Schleife beenden, da Ziel gefunden wurde.
                } else { 
                    // Wenn das gefundene Item ein Declass ist, die Ziel-ID aktualisieren und Schleife neu starten.
                    targetIdNeu = curr.directTarget.getID();
                    i = 0; // Zurücksetzen des Index für neue Suche.
                }
            }

            if (curr.getID() == targetId) {
                directLink = curr; // Direktlink für die ursprüngliche Ziel-ID setzen.
            }

            // Wenn alle Items durchsucht wurden und das Ziel-Item weiterhin ein Declass ist, Ziel zurücksetzen.
            if (i == items.size() - 1 && targetItem != null && targetItem.isDeclass) {
                targetItem = null;
            }
        }

        // Ausnahme werfen, wenn kein geeignetes Ziel-Item gefunden wurde.
        if (targetItem == null) {
            throw new IllegalArgumentException("Kein Item mit benötigter ID gefunden");
        }

        // Neues Declass-Item erstellen, das auf das Ziel verweist.
        Item declass = new Item(level, id, targetItem.getAge(), targetItem.getHealth());
        declass.isDeclass = true; // Als Declass markieren.
        declass.target = targetItem; // Ziel-Item setzen.
        declass.directTarget = directLink; // Direktlink setzen.
        return declass; // Das erstellte Declass-Item zurückgeben.
    }
}
