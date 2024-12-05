import java.util.ArrayList;

public class TransportSystemApp {
	
	public static void main(String[] args) {
		
		// ************ run some code related to task a ************
		
		Bus bus = new Bus('A', 1);
		System.out.println(bus.getTime());

		Tram tram = new Tram('B', 6);
		System.out.println(tram.getTime());
		
		Train train = new Train('C', 10);
		System.out.println(train.getTime());
		
		// ************ run some code related to task b ************
		
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
		
		Route route = ts.findFastestRoute();
		
		System.out.println(route);
	}
}
