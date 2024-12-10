public class Node implements Comparable<Node> {
	private Station station;
	private Connection conn;
	private int timeDist;
	
	public Node(Station station, Connection conn, int timeDist) {
		this.station = station;
		this.conn = conn;
		this.timeDist = 0;
	}
	
	public Station getStation() {
		return this.station;
	}
	
	public Connection getConn() {
		return this.conn;
	}
	
	public int getTimeDist() {
		return this.timeDist;
	}
	
	@Override
	public int compareTo(Node other) {
		return this.timeDist - other.timeDist;
	}
}
