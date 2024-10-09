import java.util.Random;
import java.util.Scanner;
// passt alles, auch schön elegant
public class ChatGPT {
    public static String INVALID_REGEX = "[.&%^$£@!)({}\";|/+=!`~<>,?]";

    public static void main(String[] args) {
        Scanner myConsole = new Scanner(System.in);
        Random rand = new Random();

        String name = retrieveName("Guten Tag! Ich bin ChatGPT, der beste Chatbot, den es gibt. Wie heissen Sie?", myConsole);
        int age = retrieveInt("Sehr erfreut " + name + "! Wie alt sind Sie?", myConsole);

        int random = rand.nextInt(age * 2);

        System.out.println("Mittels dieser Informationen habe ich Ihre Glückszahl gefunden! Die Glückszahl lautet " + random);
    }

    public static String retrieveName(String msg, Scanner input) {
        System.out.println(msg);
        String line = input.nextLine();
        if (line.matches(INVALID_REGEX)) {
            return retrieveName("Bitte geben Sie einen gültigen Namen ein.", input);
        } else
            return line;
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

