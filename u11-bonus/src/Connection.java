public abstract class Connection {
	final char name;
	final int distance;

	public Connection(char name, int distance) {
		this.name = name;
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public char getNextStation() {
		return name;
	}

	public int getTime() {
		return 0;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + name + ", " + distance + ")";
	}
}
