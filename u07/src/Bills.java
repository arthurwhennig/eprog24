import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Bills {

  public static void main(String[] args) throws FileNotFoundException {
    String inputFile = "Data.txt";
    Scanner input = new Scanner(new File(inputFile));
    PrintStream output = new PrintStream(new File("Output.txt"));

    process(input, output);

    input.close();
  }

  /**
   * Ändern Sie nicht die Signatur der Methode
   */
  public static void process(Scanner input, PrintStream output) {
	  ArrayList<User> users = new ArrayList<User>();
	  Tarif tarif = new Tarif(0);
	  
	  while (input.hasNextLine()) {
		  String line = input.nextLine();
		  String[] content = line.split(" ");
		  int[] data = new int[content.length];
		  for (int i = 0; i < data.length; i++) {
			  if (content[i].equals("Tarif")) data[i] = 0;
			  else data[i] = Integer.parseInt(content[i]);
		  }
		  if (line.startsWith("Tarif")) {
			  int size = Integer.parseInt(content[1]);
			  tarif = new Tarif(size);
			  for (int i = 2; i < data.length - 1; i += 2) {
				  tarif.addRule(data[i], data[i+1]);
			  }
		  } else {
			  int id = data[0];
			  User user = new User(id, tarif);
			  for (int i = 1; i <= 4 && i < data.length; i++) {
				  int quartal = data[i];
				  user.addConsumption(quartal);
			  }
			  users.add(user);
		  }
	  }
	  
	  for (User user : users) {
		  output.println(user.getBill());
	  }
  }
}