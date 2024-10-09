public class SwissFlag {

    public static char VERTICAL = '|';
    public static char HORIZONTAL = '-';
    public static char PLUS = '+';
    public static char EMPTY = ' ';

    public static void main(String[] args) {
        swissFlag(12, 6);

//        swissFlag(15, 5);

//        swissFlag(20, 7);
    }

    //sehr schöne Lösung :) cool dass du es grössenverstellbar gemacht hast
    
    
    public static void swissFlag(int a, int b) {
        int width = 7 * a - 1; // width should be odd
        horizontal(width);
        for (int i = 0; i < b-1; i++) {
            vertical(width, 0);
        }
        for (int i = 0; i < b; i++) {
            vertical(width, a);
        }
        for (int i = 0; i < b; i++) {
            vertical(width, 3 * a);
        }
        for (int i = 0; i < b; i++) {
            vertical(width, a);
        }
        for (int i = 0; i < b-1; i++) {
            vertical(width, 0);
        }
        horizontal(width);
    }

    public static void horizontal(int width) {
        for (int i = 0; i < width; i++) {
            System.out.print(HORIZONTAL);
        }
        System.out.print('\n');
    }

    public static void vertical(int width, int numPlus) {
        if (numPlus <= width - 2) {
            System.out.print(VERTICAL);
            for (int i = 0; i < (width - numPlus - 2) / 2; i++) {
                System.out.print(EMPTY);
            }
            for (int i = 0; i < numPlus; i++) {
                System.out.print(PLUS);
            }
            for (int i = 0; i < (width - numPlus - 1) / 2; i++) {
                System.out.print(EMPTY);
            }
            System.out.print(VERTICAL);
            System.out.print('\n');
        }
    }
}
