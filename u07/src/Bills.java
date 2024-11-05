import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Bills {

  public static void main(String[] args) throws FileNotFoundException {
    String inputFile = "Data.txt";
    Scanner input = new Scanner(new File(inputFile));
    PrintStream output = new PrintStream(System.out);

    process(input, output);

    input.close();
  }

  /**
   * Ändern Sie nicht die Signatur der Methode
   */
  public static void process(Scanner input, PrintStream output) {
    // TODO Lesen Sie das File von input und geben Sie Ihre Lösung nach output aus.
  }
}