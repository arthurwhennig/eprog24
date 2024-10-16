import java.util.Scanner;


public class Calculations {	
	/*
	 * Prüft ob einer der Parameter, ihre Summe oder eine ihrer Differenzen gleich 7 ist.
	 */
	public static boolean magic7(int a, int b) {
		int sum = a + b;
		int diff1 = a - b;
		int diff2 = b - a;
		
		if(a == 7 || b == 7 || sum == 7 || diff1 == 7 || diff2 == 7) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Prüft ob der Parameter z maximal 2 grösser oder kleiner als 12 ist
	 *
	 *Diese folgende Lösung kann und sollte zu follgendem Code vereinfacht werden:
	 *
	 public static boolean fast12(int z) {
	 	return (z + 2) % 12 <= 4;
	 }
	 
	 Doch für ein besseres Verständnis gibt es folgende Lösung: 
	 */
	public static boolean fast12(int z) {
		if((z + 2) % 12 <= 4) {
			return true;
		} else {
			return false;
		}
		
	}
	

}
