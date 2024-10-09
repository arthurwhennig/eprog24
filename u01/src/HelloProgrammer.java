import java.util.InputMismatchException;
import java.util.Scanner;

public class HelloProgrammer {
    
    public static void main(String[] args) {
        System.out.println("Hello Programmer"); // "Hello Programmer"

        Scanner myConsole = new Scanner(System.in);

        boolean success = false;

        int myNumber = myConsole.nextInt();

        System.out.println(myNumber);

//        while (!success) {
//            try {
//                    System.out.println("Enter a number");
//                    int a = myConsole.nextInt();
//
//                    System.out.println("Enter a number");
//                    int b = myConsole.nextInt();
//
//                    success = true;
//                System.out.println("Result: " + multiply(a, b));
//            } catch (InputMismatchException e) {
//                System.out.println("You didn't enter a number");
//                success = false;
//            }
//        }
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

}

// Hast es scheinbar verstanden :)
