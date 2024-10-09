
public class SharedDigit {
	public static void main(String[] args) {
		// Aendern Sie die Werte um verschiedene Ausfuehrungen zu testen.
		int a = 12;
		int b = 23;

		int r = -1;
		int a1 = a/10; //erste Ziffer von a
		int a2 = a % 10; //zweite Ziffer von a
		
		if (a1 == b / 10 || a1 == b % 10) { // prueft ob die erste Ziffer von a mit einer der beiden Ziffern von
													// b uebereinstimmt
			r = a1;								
		
		} else if (a2 == b / 10 || a2 == b % 10) { // prueft ob die zweite Ziffer von a mit einer der beiden
															// Ziffern von b uebereinstimmt
			r = a2;
		}

		// Der finale Wert von r wird ausgegeben
		System.out.println("a: " + a + ", b: " + b + " --> r: " + r);
	}
}
