import java.util.Scanner;

public class Adder {
    public static void main(String[] args) {
        Scanner myConsole = new Scanner(System.in);

        int first = retrieveInt("Geben Sie eine ganze Zahl 1 ein:", myConsole);
        int second = retrieveInt("Geben Sie eine ganze Zahl 2 ein:", myConsole);

        System.out.println(first + " + " + second + " = " + add(first, second));
    }

    public static int retrieveInt(String msg, Scanner input) {
        System.out.println(msg);
        try {
            String line = input.nextLine();
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return retrieveInt("Bitte geben Sie eine valide Zahl ein.", input);
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }
}

// nice, kannst auch System.out.print() verwenden,
// wenn du die Antwort nicht in einer neuen Zeile schreiben willst
