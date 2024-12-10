import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;

public class TransportSystem {
	private List<Station> stations;
	private PriorityQueue<Node> queue;
	private HashMap<Character, Station> map;
	private HashMap<Character, Record> records;
	private HashMap<Character, Connection> previous;

	public TransportSystem(List<Station> stations) {
		this.stations = stations;
		this.queue = new PriorityQueue<Node>();
		this.map = new HashMap<Character, Station>();
		this.records = new HashMap<Character, Record>();
		this.previous = new HashMap<Character, Connection>();
		
		for (Station station : stations) {
			map.put(station.getName(), station);
			records.put(station.getName(), new Record());
			previous.put(station.getName(), null);
		}
	}

	public Route findFastestRoute() {
		Station start = stations.getFirst(), dest = stations.getLast();
		
		queue.add(new Node(start, 0));
		records.get(start.getName()).busVisited = true;
		records.get(start.getName()).tramVisited = true;
		records.get(start.getName()).trainVisited = true;
		records.get(start.getName()).timeDist = 0;
		
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			Station station = curr.getStation();
			Record currRec = records.get(station.getName());
			
			Connection prev = previous.get(station.getName());
			if (prev instanceof Bus) currRec.busVisited = true;
			if (prev instanceof Tram) currRec.tramVisited = true;
			if (prev instanceof Train) currRec.trainVisited = true;
			
			for (Connection conn : station.getConnections()) {
				char next = conn.getNextStation();
				Station nextStation = map.get(next);
				Record nextRec = records.get(next);
				if (conn instanceof Bus) {
					if (nextRec.busVisited) continue;
					int newTimeDist = currRec.timeDist + conn.getTime();
					if (prev instanceof Bus) newTimeDist -= 2;
					if (newTimeDist < nextRec.timeDist) {
						nextRec.timeDist = newTimeDist;
						queue.add(new Node(nextStation, newTimeDist));
						previous.put(next, conn);
					}
				} else if (conn instanceof Tram) {
					if (nextRec.tramVisited) continue;
					int newTimeDist = currRec.timeDist + conn.getTime();
					if (prev instanceof Tram) newTimeDist -= 5;
					if (newTimeDist < nextRec.timeDist) {
						nextRec.timeDist = newTimeDist;
						queue.add(new Node(nextStation, newTimeDist));
						previous.put(next, conn);
					}
				} else if (conn instanceof Train) {
					if (nextRec.trainVisited) continue;
					int newTimeDist = currRec.timeDist + conn.getTime();
					if (prev instanceof Train) newTimeDist -= 10;
					if (newTimeDist < nextRec.timeDist ) {
						nextRec.timeDist = newTimeDist;
						queue.add(new Node(nextStation, newTimeDist));
						previous.put(next, conn);
					}
				}
			}
		}
		
		Record destRec = records.get(dest.getName());
		if (!destRec.visited()) return null;
		
		ArrayList<Connection> list = new ArrayList<Connection>();
		
		Connection conn = previous.get(dest.getName());
		while (conn != null) {
			list.addFirst(conn);
			for (Station station : this.stations) {
				if (station.getConnections().contains(conn)) {
					conn = previous.get(station.getName());
				}
			}
		}
		
		return new Route(destRec.timeDist, list);
	}
}