public class Response {
	private int head;
	private int tail;
	
	public Response(int head, int tail) {
		this.head = head;
		this.tail = tail;
	}

	@Override
	public String toString() {
		return "Response(" + head + ", " + tail+ ")";
	}
	
	public int getHead() {
		return head;
	}

	public int getTail() {
		return tail;
	}
	
}
