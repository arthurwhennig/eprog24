import java.util.Scanner;

 /* 
 * Liest eine Serie von Zahlen von der Konsole ein, füllt damit eine LinkedIntList und 
 * gibt sie wieder aus.
 */
public class Echo {
    
    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList();
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNextInt()) {
            list.addLast(scanner.nextInt());
        }
        
        int[] listAsArray = list.toArray();
        
        for(int i = 0; i < listAsArray.length; ++i) {
            System.out.println(i);
        }
    }
}
