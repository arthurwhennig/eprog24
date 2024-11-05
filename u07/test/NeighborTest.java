import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NeighborTest {

  @Test
  public void testNeighbor() {
    assertEquals(new int[] {5,4,7}, Neighbor.neighbor(new int[] {1,4,5,7,9,10}, 5));
    assertTrue(Neighbor.neighbor(new int[] {1,4,6,7,9,10}, 5) == new int[] {5,4,6}
            || Neighbor.neighbor(new int[] {1,4,6,7,9,10}, 5) == new int[] {5,6,4});
    assertEquals(new int[] {10,9,6}, Neighbor.neighbor(new int[] {1,4,6,7,9,10}, 10));
  }
}

