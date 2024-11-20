import java.util.Arrays;

public class WaitQueueServerApp {

    public static void main(String[] args) {
    	
    	WaitQueueServer server = new WaitQueueServer(7);
    	Response resultA = server.add(0, 'A', true);
        System.out.println("add(0, 'A', true) returns " + resultA);
    	Response resultB = server.add(0, 'B', false);
        System.out.println("add(0, 'B', false) returns " + resultB);

        char [] resultC = server.pop(0);
        System.out.println("pop(0) returns " + Arrays.toString(resultC));

        int[][] resultD = server.getQuickList();
        System.out.println("getQuickList() returns " + Arrays.deepToString(resultD));
        
    }
}
