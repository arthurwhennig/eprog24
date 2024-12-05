import java.util.List;

public class Station {
	private char name;
	private List<Connection> connections;

	public Station(char name, List<Connection> connections) {
		this.name = name;
		this.connections = connections;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public List<Connection> getConnections() {
		return connections;
	}

	@Override
	public String toString() {
		return "Station [name=" + name + ", connections=" + connections + "]";
	}
}
