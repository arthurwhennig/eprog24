
public class Option extends EBNFNode {
	
	private final EBNFNode child;
	
	public Option(EBNFNode child) {
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
		return "Option(" + child + ")";
	}
}
