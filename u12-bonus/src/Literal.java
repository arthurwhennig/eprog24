
public class Literal extends EBNFNode {
	
	private final char literal;
	
	public Literal(char literal) {
		super();
		this.literal = literal;
	}
	
	@Override
	public String toEBNFString() {
		// TODO task a
		
		return null;
	}

	@Override
	public String toString() {
		return "Literal(" + literal + ")";
	}
	
}
