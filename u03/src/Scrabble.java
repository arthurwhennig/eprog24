/*
 * Dieses Programm gibt den eingegebenen Namen als in einem Quadrat angeordnete Scrabble-Steine aus.
 */
public class Scrabble {

    public static void main(String[] args) {
		drawNameSquare("Ben Kracht");
	}


    public static void drawNameSquare(String name) {
        String upper = name.toUpperCase();

        drawTop(upper);

        drawVertical(upper);

        drawBottom(upper);
    }

    public static void drawTop(String name) {
        int len = name.length();
        for (int i = 0; i < len; i++) {
            System.out.print("+---");
        }
        System.out.print("+\n");
        for (int i = 0; i < len; i++) {
            System.out.print("| " + name.charAt(i) + " ");
        }
        System.out.print("|\n");
        for (int i = 0; i < len; i++) {
            System.out.print("+---");
        }
        System.out.print("+\n");
    }

    public static void drawVertical(String name) {
        int len = name.length();
        for (int i = 1; i < len-1; i++) {
            System.out.print("| " + name.charAt(i) + " |");
            for (int j = 0; j < 4*(len-2)-1; j++) {
                System.out.print(" ");
            }
            System.out.print("| " + name.charAt(len-1-i) + " |\n");
            if (i != len-2) {
                System.out.print("+---+");
                for (int j = 0; j < 4*(len-2)-1; j++) {
                    System.out.print(" ");
                }
                System.out.print("+---+\n");
            }
        }
    }

    public static void drawBottom(String name) {
        int len = name.length();
        for (int i = 0; i < len; i++) {
            System.out.print("+---");
        }
        System.out.print("+\n");
        for (int i = 0; i < len; i++) {
            System.out.print("| " + name.charAt(len-1-i) + " ");
        }
        System.out.print("|\n");
        for (int i = 0; i < len; i++) {
            System.out.print("+---");
        }
        System.out.print("+\n");
    }

}
