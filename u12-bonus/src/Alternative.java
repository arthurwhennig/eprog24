
public class Alternative extends EBNFNode {

	private final EBNFNode first, second;
	
	public Alternative(EBNFNode first, EBNFNode second) {
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public String toEBNFString() {
		// TODO task a
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Alternative(" + first + ", " + second + ")";
	}

}
