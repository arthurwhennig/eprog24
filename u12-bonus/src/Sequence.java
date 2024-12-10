
public class Sequence extends EBNFNode {
	
	private final EBNFNode left, right;
	
	public Sequence(EBNFNode left, EBNFNode right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public String toEBNFString() {
		// TODO task a
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Sequence(" + left + ", " + right + ")";
	}
}
