
public class Brackets extends EBNFNode {

	private final EBNFNode child;
	
	public Brackets(EBNFNode child) {
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
		return "Brackets(" + child + ")";
	}
}
