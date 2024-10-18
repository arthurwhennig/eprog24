import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*
 * Dieses Programm liest einen String ein, der eine Siebensegmentanzeige kodiert, und gibt die kodierte Zahl als Integer aus.
 */
public class Zahlen {

	public static void main(String[] args) {
		Scanner myConsole = new Scanner(System.in);
		String segment = retrieveSegment("Enter the seven-segment:", myConsole);

		int num = recognizeNumber(segment);
		if (num == -1) {
			System.out.println("Could not recognize number.");
		}


		System.out.println(num);
	}

	public static String retrieveSegment(String msg, Scanner input) {
		System.out.println(msg);
		String line = input.nextLine();
		if (!line.matches("^[abcdefg]+$")) {
			return retrieveSegment("Please enter a valid seven-segment.", input);
		}
		return line;
	}

	public static int recognizeNumber(String segment) {
		boolean[] states = new boolean[7];
		for (int i = 0; i < segment.length(); i++) {
			int idx = segment.charAt(i) - 'a';
			states[idx] = true;
		}

		if (states[0] && states[1] && states[2] && states[3] && states[4] && states[5] && !states[6]) return 0;
		if (states[1] && states[2] && !states[0] && !states[3] && !states[4] && !states[5] && !states[6]) return 1;
		if (states[0] && states[1] && states[3] && states[4] && states[6] && !states[2] && !states[5]) return 2;
		if (states[0] && states[1] && states[2] && states[3] && states[6] && !states[4] && !states[5]) return 3;
		if (states[1] && states[2] && states[5] && states[6] && !states[0] && !states[3] && !states[4]) return 4;
		if (states[0] && states[2] && states[3] && states[5] && states[6] && !states[1]) return states[4] ? 6 : 5;
		if (states[0] && states[1] && states[2] && !states[3] && !states[4] && !states[5]) return 7;
		if (states[0] && states[1] && states[2] && states[3] && states[5] && states[6]) return states[4] ? 8 : 9;
        return -1;
    }
}
