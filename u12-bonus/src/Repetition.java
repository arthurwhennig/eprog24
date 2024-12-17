import java.util.Set;
import java.util.TreeSet;

public class Repetition extends EBNFNode {
	
	private final EBNFNode child;
	
	public Repetition(EBNFNode child) {
		super();
		this.child = child;
	}

	@Override
	public String toEBNFString() {
		return "{" + this.child.toEBNFString() + "}";
	}

	@Override
	public String toString() {
		return "Repetition(" + child + ")";
	}
	
	@Override
	public Set<String> getShortestWords(EBNFRules rules, int limit) {
		TreeSet<String> newSet = new TreeSet<String>();
		Set<String> childSet = this.child.getShortestWords(rules, limit);
		for (String s : childSet) {
			String repeated = "";
			while (repeated.length() <= limit) {
				newSet.add(repeated);
				repeated = repeated + s;
			}
		}
		return newSet;
	}
}
