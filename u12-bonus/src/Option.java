import java.util.Set;
import java.util.TreeSet;

public class Option extends EBNFNode {
	
	private final EBNFNode child;
	
	public Option(EBNFNode child) {
		super();
		this.child = child;
	}

	@Override
	public String toEBNFString() {
		return "[" + this.child.toEBNFString() + "]";
	}
	
	@Override
	public String toString() {
		return "Option(" + child + ")";
	}
	
	@Override
	public Set<String> getShortestWords(EBNFRules rules, int limit) {
		TreeSet<String> newSet = new TreeSet<String>();
		Set<String> childSet = this.child.getShortestWords(rules, limit);
		
		for (String s : childSet) {
			if (s.length() <= limit) newSet.add(s);
		}
		newSet.add("");
		
		return newSet;
	}
}
