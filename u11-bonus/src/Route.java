import java.util.List;

public class Route {
	int time;
	List<Connection> connections;

	public Route(int time, List<Connection> connections) {
		this.time = time;
		this.connections = connections;
	}

	public String toString() {
		return "Route(time=" + time + ", connections=" + connections + ")";
	}

	public int getTime() {
		return time;
	}

	public List<Connection> getConnections() {
		return connections;
	}
}
