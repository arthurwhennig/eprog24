import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

public class WaitQueueServerTest {

	@Test
	public void testAdd() {
		// Queue array size N=8
		// Waiting Queue Array:
		// fileID: 0 0 1 1 0 1 2 3
		// userID: A B C A C B D E
		//  read?: T F F T T F T F
		WaitQueueServer queueServer = new WaitQueueServer(8); 
		
		Response r0 = queueServer.add(0, 'A', true);
		assertEquals(0, r0.getHead());
		assertEquals(0, r0.getTail());
		
		Response r1 = queueServer.add(0, 'B', false);
		
		assertEquals(0, r1.getHead());
		assertEquals(1, r1.getTail());
		
		Response r2 = queueServer.add(1, 'C', false);
		
		assertEquals(2, r2.getHead());
		assertEquals(2, r2.getTail());
		
		Response r3 = queueServer.add(1, 'A', true );
		
		assertEquals(2, r3.getHead());
		assertEquals(3, r3.getTail());
		
		Response r4 = queueServer.add(0, 'C', true );
		
		assertEquals(0, r4.getHead());
		assertEquals(4, r4.getTail());
		
		Response r5 = queueServer.add(1, 'B', false);
		
		assertEquals(2, r5.getHead());
		assertEquals(5, r5.getTail());
		
		Response r6 = queueServer.add(2, 'D', true );
		
		assertEquals(6, r6.getHead());
		assertEquals(6, r6.getTail());

		Response r7 = queueServer.add(3, 'E', false);
		
		assertEquals(7, r7.getHead());
		assertEquals(7, r7.getTail());
		
		assertNull(queueServer.add(3, 'F', false));
	}

	@Test
	public void testPop() {
		// Queue array size N=8

		WaitQueueServer queueServer = new WaitQueueServer(8);
		queueServer.add(0, 'A', true );
		queueServer.add(0, 'B', false);
		queueServer.add(1, 'C', false);
		queueServer.add(1, 'A', true );
		queueServer.add(0, 'C', true );
		queueServer.add(1, 'B', false);
		queueServer.add(2, 'D', true );
		queueServer.add(3, 'E', false);
		// Waiting Queue Array:
		//  index: 0 1 2 3 4 5 6 7
		// fileID: 0 0 1 1 0 1 2 3
		// userID: A B C A C B D E
		//  read?: T F F T T F T F
		assertArrayEquals(new char [] {'A', 'C'}, queueServer.pop(0));
		// Waiting Queue Array:
		//  index: 0 1 2 3 4 5 6 7
		// fileID: - 0 1 1 - 1 2 3
		// userID: - B C A - B D E
		//  read?: - F F T - F T F
		assertArrayEquals(new char [] {'C'}, queueServer.pop(1));
		// Waiting Queue Array:
		//  index: 0 1 2 3 4 5 6 7
		// fileID: - 0 - 1 - 1 2 3
		// userID: - B - A - B D E
		//  read?: - F - T - F T F
		queueServer.add(1, 'F', true );
		assertArrayEquals(new char [] {'A', 'F'}, queueServer.pop(1));
		// Waiting Queue Array:
		//  index: 0 1 2 3 4 5 6 7
		// fileID: - 0 - - - 1 2 3
		// userID: - B - - - B D E
		//  read?: - F - - - F T F
		assertNull(queueServer.pop(4));
	}

	@Test
	public void testGetQuickList() {
		// Queue array size N=8

		WaitQueueServer queueServer = new WaitQueueServer(8);
		queueServer.add(0, 'A', true );
		queueServer.add(0, 'B', false);
		queueServer.add(1, 'C', false);
		queueServer.add(1, 'A', true );
		queueServer.add(0, 'C', true );
		queueServer.add(1, 'B', false);
		queueServer.add(2, 'D', true );
		queueServer.add(3, 'E', false);
        queueServer.pop(0);
		// Waiting Queue Array:
		//  index: 0 1 2 3 4 5 6 7
		// fileID: - 0 1 1 - 1 2 3
		// userID: - B C A - B D E
		//  read?: - F F T - F T F
        int [][] resultA = queueServer.getQuickList();
        int [][] expectedA = {{0,1,1}, {1,2,5}, {2,6,6}, {3,7,7}};
        assertArrayEquals(expectedA, resultA);
        
        queueServer.pop(1);
		// Waiting Queue Array:
		//  index: 0 1 2 3 4 5 6 7
		// fileID: - 0 - 1 - 1 2 3
		// userID: - B - A - B D E
		//  read?: - F - T - F T F
        int [][] resultB = queueServer.getQuickList();
        int [][] expectedB = {{0,1,1}, {1,3,5}, {2,6,6}, {3,7,7}};
        assertArrayEquals(expectedB, resultB);
        
		queueServer.add(1, 'F', true );
		// Waiting Queue Array:
		//  index: 0 1 2 3 4 5 6 7
		// fileID: 1 0 - 1 - 1 2 3
		// userID: F B - A - B D E
		//  read?: T F - T - F T F
		int [][] resultC = queueServer.getQuickList();
        int [][] expectedC = {{0,1,1}, {1,3,0}, {2,6,6}, {3,7,7}};
        assertArrayEquals(expectedC, resultC);
        
		queueServer.pop(2);
		queueServer.add(3, 'F', true);
		// Waiting Queue Array:
		//  index: 0 1 2 3 4 5 6 7
		// fileID: 1 0 3 1 - 1 - 3
		// userID: F B F A - B - E
		//  read?: T F T F - F - F
		int [][] resultD = queueServer.getQuickList();
        int [][] expectedD = {{0,1,1}, {1,3,0}, {3,7,2}};
        assertArrayEquals(expectedD, resultD);
	}
}
