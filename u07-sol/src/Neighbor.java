import java.util.Arrays;

public class Neighbor {
    public static void main(String[] args) {
        // Beispiele vom Arbeitsblatt
        int[] a = neighbor(new int[] {1,4,5,7,9,10}, 5);
        System.out.println(" Die nächten Neighbours sind:" + Arrays.toString(a));
        int[] b = neighbor(new int[] {1,4,5,6,9,10}, 5);
        System.out.println(" Die nächten Neighbours sind:" + Arrays.toString(b));
        int[] c = neighbor(new int[] {1,4,5,6,9,10}, 10);
        System.out.println(" Die nächten Neighbours sind:" + Arrays.toString(c));
    }

    public static int[] neighbor(int[] sequence, int key) {
        int len = sequence.length;
        int[] ret = new int[3];
        int index = 0;
        while (sequence[index] < key) index++; // find where sequence[i] == key or is larger
        int right = index;
        int left = index-1;
        for (int i = 0; i < 3; i++) { // test which number is closer
            if(left < 0 || (right < len && isCloser(right, left, key, sequence))) { 
                ret[i] = sequence[right];
                right++;
            } else {
                ret[i] = sequence[left];
                left--;
            }
        }
        return ret;
    }

    public static boolean isCloser(int index1, int index2, int key, int[] sequence) {
        return (Math.abs(sequence[index1] - key) < Math.abs(sequence[index2] - key));
    }
    
}

