
public class RuleName extends EBNFNode {
	
	private final String name;
	
	public RuleName(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toEBNFString() {
		// TODO task a
		
		return null;
	}
	
	@Override
	public String toString() {
		return "RuleName(" + name + ")";
	}
}
