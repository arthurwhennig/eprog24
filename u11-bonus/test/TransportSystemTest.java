import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TransportSystemTest {
	
	/**
	 * Compares that two Route are equal
	 */
	public void assertRouteEquals(Route expected, Route actual) {
		
		// Check for null first
		if(expected == null) {
			assertNull(actual); // actual should be null
			return;
		} else {
			assertNotNull(actual); // actual should not be null
		}
		
		// Time should be equal
		assertEquals(expected.getTime(), actual.getTime());
		
		List<Connection> expectedConnections = expected.getConnections();
		List<Connection> actualConnections = actual.getConnections();
		
		// The connections should not be null
		assertNotNull(actualConnections);
		
		// The connection lists should have the same size
		assertEquals(expectedConnections.size(), actualConnections.size());
		
		// Check every connection
		for(int i=0; i<expectedConnections.size(); ++i) {
			Connection expectedConnection = expectedConnections.get(i);
			Connection actualConnection = actualConnections.get(i);
			
			// The connection should go to the same station
			assertEquals(expectedConnection.getNextStation(), actualConnection.getNextStation());
			
			// The connection should have the same distance
			assertEquals(expectedConnection.getDistance(), actualConnection.getDistance());
			
			// The connection should use the same mode of transport
			assertEquals(expectedConnection instanceof Bus, actualConnection instanceof Bus);
			assertEquals(expectedConnection instanceof Tram, actualConnection instanceof Tram);
			assertEquals(expectedConnection instanceof Train, actualConnection instanceof Train);
		}
		
	}
	
	@Test
	public void testGetTime() {
		Bus bus = new Bus('A', 1);
		assertEquals(10, bus.getTime());

		Tram tram = new Tram('B', 2);
		assertEquals(20, tram.getTime());
		
		Train train = new Train('C', 10);
		assertEquals(36, train.getTime());
	}
	
	@Test
	public void testGetShortestRoute0() {
		ArrayList<Connection> listA = new ArrayList<Connection>();
		listA.add(new Bus('B', 7));
		listA.add(new Tram('B', 7));
		listA.add(new Train('B', 7));
		
		Station a = new Station('A', listA);
		Station b = new Station('B', new ArrayList<Connection>());
		
		ArrayList<Station> stations = new ArrayList<Station>();
		stations.add(a);
		stations.add(b);
		
		TransportSystem ts = new TransportSystem(stations);
		
		Route actual = ts.findFastestRoute();
		
		
		ArrayList<Connection> expectedConnections = new ArrayList<Connection>();
		expectedConnections.add(new Tram('B', 7));
		Route expected = new Route(30, expectedConnections);
		
		assertRouteEquals(expected, actual);
	}

	@Test
	public void testGetShortestRoute1() {
		ArrayList<Connection> listA = new ArrayList<Connection>();
		listA.add(new Bus('B', 2));
		listA.add(new Tram('B', 2));
		listA.add(new Train('B', 1));
		listA.add(new Tram('C', 3));
		
		Station a = new Station('A', listA);
		
		ArrayList<Connection> listB = new ArrayList<Connection>();
		listB.add(new Train('Z', 20));
		listB.add(new Bus('C', 2));
		
		Station b = new Station('B', listB);
		
		ArrayList<Connection> listC = new ArrayList<Connection>();
		listC.add(new Train('Z', 10));
		Station c = new Station('C', listC);
		
		Station z = new Station('Z', new ArrayList<Connection>());
		
		
		ArrayList<Station> stations = new ArrayList<Station>();
		stations.add(a);
		stations.add(b);
		stations.add(c);
		stations.add(z);
		
		TransportSystem ts = new TransportSystem(stations);
		
		Route actual = ts.findFastestRoute();
		
		
		ArrayList<Connection> expectedConnections = new ArrayList<Connection>();
		expectedConnections.add(new Bus('B', 2));
		expectedConnections.add(new Bus('C', 2));
		expectedConnections.add(new Train('Z', 10));
		Route expected = new Route(54, expectedConnections);
		System.out.println(actual);
		System.out.println(expected);
		assertRouteEquals(expected, actual);
	}
	
	@Test
	public void testGetShortestRoute2() {
		ArrayList<Connection> listA = new ArrayList<Connection>();
		listA.add(new Bus('E', 2));
		listA.add(new Tram('E', 2));
		listA.add(new Train('E', 1));
		
		Station a = new Station('A', listA);
		
		ArrayList<Connection> listE = new ArrayList<Connection>();
		listE.add(new Bus('F', 8));
		listE.add(new Train('F', 2));
		
		Station e = new Station('E', listE);

		Station f = new Station('F', new ArrayList<Connection>());
		
		ArrayList<Connection> listZ = new ArrayList<Connection>(); 
		listZ.add(new Tram('F', 25));
		Station z = new Station('Z', listZ);
		
		ArrayList<Station> stations = new ArrayList<Station>();
		stations.add(a);
		stations.add(e);
		stations.add(f);
		stations.add(z);
		
		TransportSystem ts = new TransportSystem(stations);
		
		Route actual = ts.findFastestRoute();
		Route expected = null;
		
		assertRouteEquals(expected, actual);
	}
}
