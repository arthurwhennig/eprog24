public class Tram extends Connection {

	public Tram(char name, int distance) {
		super(name, distance);
	}

	@Override
	public int getTime() {
		return 20 + Math.max(0, (distance - 5) * 5);
	}
}
