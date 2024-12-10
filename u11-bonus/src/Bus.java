public class Bus extends Connection {

	public Bus(char name, int distance) {
		super(name, distance);
	}

	@Override
	public int getTime() {
		return 10 + Math.max(0, (distance - 2) * 7);
	}
}
