import java.util.Set;

public class Brackets extends EBNFNode {

	private final EBNFNode child;
	
	public Brackets(EBNFNode child) {
		super();
		this.child = child;
	}

	@Override
	public String toEBNFString() {
		return "(" + this.child.toEBNFString() + ")";
	}
	
	@Override
	public String toString() {
		return "Brackets(" + child + ")";
	}
	
	@Override
	public Set<String> getShortestWords(EBNFRules rules, int limit) {
		return null;
	}
}
