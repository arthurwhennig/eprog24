public class Node implements Comparable<Node> {
	private Station station;
	private int timeDist;
	
	public Node(Station station, int timeDist) {
		this.station = station;
		this.timeDist = 0;
	}
	
	public Station getStation() {
		return this.station;
	}
	
	public int getTimeDist() {
		return this.timeDist;
	}
	
	@Override
	public int compareTo(Node other) {
		return this.timeDist - other.timeDist;
	}
}
