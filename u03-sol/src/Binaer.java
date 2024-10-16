import java.util.Scanner;
/*
 * Dieses Programm gibt die Binaerdarstellung einer positiven Zahl aus, ohne Arrays oder String-
 * Operationen (+ ist erlaubt).
 */
public class Binaer {
	/*
	 * Bestimmt exp so, dass 2^exp <= number und 2^(exp + 1) > number gilt.
	 */
	public static int largestExponent(int number) {
		
		int largestPowerOfTwo = 1; // 2^0 = 1
		int exp = 0;
		
		if(number <= 0) {
			System.out.println("Keine positive ganze Zahl!");
		} else {
			while(largestPowerOfTwo <= number) { //Erhöhe exp
				exp = exp + 1;
				largestPowerOfTwo = largestPowerOfTwo * 2; //2^exp
			}
			// largestPowerOfTwo > number gilt hier aber es gilt 2 ^ (exp - 1) <= number
			// deshalb gehen wir einen Schritt zurück
			largestPowerOfTwo = largestPowerOfTwo / 2;
			exp = exp - 1;
		}
		
		return exp;
	}
	
	/*
	 * Gibt die Binaerdarstellung von number aus gegeben dem grössten exp,
	 * wo 2^exp <= number und 2^(exp + 1) > number gilt und 
	 */
	public static String binaerDarstellung(int number, int exp, int largestPowerOfTwo) {
		// Dummy variables to make code more readable
		int currentPowerOfTwo = largestPowerOfTwo;
		int remainingNumber = number;
		int currentExp = exp;
		
		String bDarstellung = "";
		
		while(currentExp >= 0) {
			// Prüfe ob verbleibende Zahl grösser (1) oder kleiner (0) als die currentPowerOfTwo ist
			int digit = remainingNumber / currentPowerOfTwo;
			
			// Füge digit an binärdarstellung an - nutzt int cast zu string bei + mit string
			bDarstellung = bDarstellung + digit;
			
			// Gehe zur nächstkleineren Zweierpotenz
			remainingNumber = remainingNumber - digit * currentPowerOfTwo;
			currentExp = currentExp - 1;
			currentPowerOfTwo = currentPowerOfTwo / 2;
		}
		
		return bDarstellung;
	}
	
	
	
    
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Geben Sie eine positive ganze Zahl ein: ");
		int number = console.nextInt();
		
		int exp = largestExponent(number);
		int largestPowerOfTwo = (int) Math.pow(2, exp); // Casr da Math.pow double zurückgibt
		
		String bDarstellung = binaerDarstellung(number, exp, largestPowerOfTwo);
		
		System.out.println(bDarstellung);
	}
	
	
	/*
	 * Alternative Lösung
	 * 
	 * 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine positive ganze Zahl ein: ");
        int z = scanner.nextInt();
        if(z <= 0) {
            System.out.println("Keine positive ganze Zahl!");
        }
        else {
            // Finde twoToTheK = 2^k <= z
            int k = 0;
            int twoToTheK = 1;
            while(z >= twoToTheK) {
                k++;
                twoToTheK *= 2;
            }
            k--;
            twoToTheK /= 2;
            
            // Drucke einzelne Ziffern der Binaerdarstellung von z
            while(k >= 0) {
                int digit = z / twoToTheK;
                z -= digit * twoToTheK;
                System.out.print(digit);
                
                k--;
                twoToTheK /= 2;
            }
            System.out.println();
        }
    }*/
}
