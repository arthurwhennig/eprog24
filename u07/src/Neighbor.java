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
        // TODO
        return null;
    }
}
