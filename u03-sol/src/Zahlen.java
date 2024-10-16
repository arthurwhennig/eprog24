import java.util.Scanner;




public class Zahlen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine kodierte Anzeige an: ");
        String encoding = scanner.next();

        int decodedNumber = dekodiereAnzeige(encoding);
        System.out.println(decodedNumber);
    }

    // Hauptmethode zur Dekodierung der Anzeige und Rückgabe der entsprechenden Zahl
   
    public static int dekodiereAnzeige(String encoding) {
    	 //0,1,2,3,4,5,6,7,8,9
    	
        if (encoding.contains("f")) {
        	//0,4,5,6,8,9
            return dekodiereFGruppe(encoding);
        } else {
        	//1,2,3,7
            return dekodiereKeineFGruppe(encoding);
        }
    }

    // Dekodiert die Zahlen, wenn 'f' enthalten ist
    public static int dekodiereFGruppe(String encoding) {
    	//0,4,5,6,8,9
        if (encoding.contains("b")) {
        	//0,4,8,9
            return dekodiereBGruppe(encoding);
        } else {
        	//5,6
            return dekodiereKeineBGruppe(encoding);
        }
    }
    
    // Dekodiert die Zahlen, wenn 'f' nicht enthalten ist
    public static int dekodiereKeineFGruppe(String encoding) {
    	//1,2,3,7
        if (encoding.contains("d")) {
        	//2,3
            return dekodiereDGruppe(encoding);
        } else {
        	//1,7
            return dekodiereKeineDGruppe(encoding);
        }
    }

    // Dekodiert die Zahlen, wenn 'b' enthalten ist
    public static int dekodiereBGruppe(String encoding) {
    	//0,4,8,9
    	if (encoding.contains("e")) {
    		//0,8
            if (encoding.contains("g")) {
                return 8; // Nur 8 bleibt übrig
            } else {
                return 0; // Nur 0 bleibt übrig
            }
        } else {
        	//4,9
            if (encoding.contains("a")) {
                return 9; // Nur 9 bleibt übrig
            } else {
                return 4; // Nur 4 bleibt übrig
            }
        }
    }

    // Dekodiert die Zahlen, wenn 'b' nicht enthalten ist
    public static int dekodiereKeineBGruppe(String encoding) {
    	//5,6
    	if (encoding.contains("e")) {
            return 6; // Nur 6 bleibt übrig
        } else {
            return 5; // Nur 5 bleibt übrig
        }
    }

  
    // Dekodiert die Zahlen, wenn 'd' enthalten ist
    public static int dekodiereDGruppe(String encoding) {
    	//2,3
    	if (encoding.contains("c")) {
            return 3; // Nur 3 bleibt übrig
        } else {
            return 2; // Nur 2 bleibt übrig
        }
    }

    // Dekodiert die Zahlen, wenn 'd' nicht enthalten ist
    public static int dekodiereKeineDGruppe(String encoding) {
        //1,7
    	if (encoding.contains("a")) {
            return 7; // Nur 7 bleibt übrig
        } else {
            return 1; // Nur 1 bleibt übrig
        }
    }
}

/* Kodierungen:
 *  _
 * | |
 * |_| = "abcdef"
 * 
 *   |
 *   | = "bc"
 *  _
 *  _|
 * |_  = "abdeg"
 *  _
 *  _|
 *  _| = "abcdg"
 *  
 * |_|
 *   | = "bcfg"
 *  _
 * |_
 *  _| = "acdfg"
 *  _
 * |_
 * |_| = "acdefg"
 *  _
 *   |
 *   | = "abc"
 *  _
 * |_|
 * |_| = "abcdefg"
 *  _
 * |_|
 *  _| = "abcdfg"
 */
