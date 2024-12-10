
public class Repetition extends EBNFNode {
	
	private final EBNFNode child;
	
	public Repetition(EBNFNode child) {
		super();
		this.child = child;
	}

	@Override
	public String toEBNFString() {
		// TODO task a
		
		return null;
	}

	@Override
	public String toString() {
		return "Repetition(" + child + ")";
	}
}
