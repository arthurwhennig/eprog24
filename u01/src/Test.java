import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hey there");

        Scanner console = new Scanner(System.in);
//        console.nextInt();
//        console.nextLine();
        console.close();

        Random zufall = new Random();
        int a = zufall.nextInt();
        int b = zufall.nextInt(3, 7);
        double c = zufall.nextDouble() * 100;

        System.out.println(a + " " + b + " " + c);


    }
}
