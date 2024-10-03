import java.util.Random;
import java.util.Scanner;

public class Wuerfel {
    public static void main(String[] args) {
        Scanner myConsole = new Scanner(System.in);
        Random rand = new Random();

        int numSides = Math.abs(retrieveInt("Wie viele Seiten hat ihr Würfel?", myConsole));

        int randomSide = rand.nextInt(1, numSides+1);
        System.out.println("Es wurde eine " + randomSide + " gewürfelt.");
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
}
