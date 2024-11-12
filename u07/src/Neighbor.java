import java.util.Arrays;

public class Neighbor {
    public static void main(String[] args) {
        // Beispiele vom Arbeitsblatt
        int[] a = neighbor(new int[] {1,4,5,7,9,10}, 5);
        System.out.println(" Die nächsten Neighbours sind:" + Arrays.toString(a));
        int[] b = neighbor(new int[] {1,4,5,6,9,10}, 5);
        System.out.println(" Die nächsten Neighbours sind:" + Arrays.toString(b));
        int[] c = neighbor(new int[] {1,4,5,6,9,10}, 10);
        System.out.println(" Die nächsten Neighbours sind:" + Arrays.toString(c));
    }
    public static int[] neighbor(int[] sequence, int key) {
    	int xa = Integer.MAX_VALUE-key, xb = Integer.MAX_VALUE-key, xc = Integer.MAX_VALUE-key;
    	
    	for (int i = 0; i < sequence.length; i++) {
    		int diff = Math.abs(key - sequence[i]);
    		if (diff < Math.abs(key - xa)) {
    			xc = xb;
    			xb = xa;
    			xa = sequence[i];
    		} else if (diff < Math.abs(key - xb)) {
    			xc = xb;
    			xb = sequence[i];
    		} else if (diff < Math.abs(key - xc)) {
    			xc = sequence[i];
    		}
    	}
    	
    	return new int[] { xa, xb, xc };
    }
}
