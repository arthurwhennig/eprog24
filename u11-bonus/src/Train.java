public class Train extends Connection {

	public Train(char name, int distance) {
		super(name, distance);
	}

	@Override
	public int getTime() {
		return 32 + Math.max(0, (distance - 8) * 2);
	}
}
