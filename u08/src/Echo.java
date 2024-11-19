import java.util.Scanner;

public class Echo {
	public static void main(String[] args) {
		Scanner myConsole = new Scanner(System.in);
		LinkedIntList list = new LinkedIntList();
		
		while (myConsole.hasNextInt()) {
			int val = myConsole.nextInt();
			list.addLast(val);
		}
		
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println("Index 0: " + list.get(i));
		}
	}
}
