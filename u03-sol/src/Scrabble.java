/*
 * Dieses Programm gibt den eingegebenen Namen als in einem Quadrat angeordnete Scrabble-Steine aus.
 */
public class Scrabble {

    public static void main(String[] args) {
        drawNameSquare("Jan");
    }

    public static void drawNameSquare(String name) {
        name = name.toUpperCase();
        int n = name.length();

        // Drucke den obersten Rahmen
        printBorder(n);

        // Drucke name im gewünschten Format | N | A | M | E |
        printNameRow(name);

        // Drucke den unteren Rahmen der obersten Zeile
        printBorder(n);

        // Drucke den Vertikalen Teil des Quadrats
        printVerticalPart(name);

        // Drucke die mittlere Zeile
        printMiddleRow(name);

        // Drucke den oberen Rahmen der untersten Zeile
        printBorder(n);

        // Drucke name im gewünschten Format rückwärts | E | M | A | N |
        printReversedNameRow(name);

        // Drucke den untersten Rahmen
        printBorder(n);
    }

    // Methode zum Drucken des Rahmens
    private static void printBorder(int n) {
        System.out.print("+");
        for (int i = 0; i < n; i += 1) {
            System.out.print("---+");
        }
        System.out.println();
    }

    // Methode zum Drucken des Namens in einer horizontalen Zeile (z. B. | N | A | M | E |)
    private static void printNameRow(String name) {
        System.out.print("|");
        for (int i = 0; i < name.length(); i++) {
            System.out.print(" " + name.charAt(i) + " |");
        }
        System.out.println();
    }

    // Methode zum Rückwärtsdrucken des Namens in einer horizontalen Zeile (z. B. | E | M | A | N |)
    private static void printReversedNameRow(String name) {
        System.out.print("|");
        for (int i = name.length() - 1; i >= 0; i--) {
            System.out.print(" " + name.charAt(i) + " |");
        }
        System.out.println();
    }

    // Methode zum Drucken des vertikalen Teils des Quadrats
    private static void printVerticalPart(String name) {
        int n = name.length();
        int gapLength = (n - 2) * 4 - 1; // Länge der Lücke in der Mitte

        for (int j = 1; j < n - 2; j++) {
            // Drucke den vertikalen Teil (links und rechts mit Platz in der Mitte)
            System.out.print("| " + name.charAt(j) + " |");
            for (int i = 0; i < gapLength; i++) {
                System.out.print(" ");
            }
            System.out.print("| " + name.charAt(n - 1 - j) + " |");
            System.out.println();

            // Drucke die horizontale Linie zwischen den Reihen in der Mitte
            System.out.print("+---+");
            for (int i = 0; i < gapLength; i++) {
                System.out.print(" ");
            }
            System.out.print("+---+");
            System.out.println();
        }
    }

    // Methode zum Drucken der mittleren Zeile des Quadrats
    private static void printMiddleRow(String name) {
        int n = name.length();
        int gapLength = (n - 2) * 4 - 1;

        System.out.print("| " + name.charAt(n - 2) + " |");
        for (int i = 0; i < gapLength; i++) {
            System.out.print(" ");
        }
        System.out.print("| " + name.charAt(1) + " |");
        System.out.println();
    }
       
}
