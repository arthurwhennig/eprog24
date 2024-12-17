import java.util.Set;
import java.util.TreeSet;

public class Sequence extends EBNFNode {
	
	private final EBNFNode left, right;
	
	public Sequence(EBNFNode left, EBNFNode right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public String toEBNFString() {
		String first = this.left.toEBNFString();
		String second = this.right.toEBNFString();
		if (this.left instanceof Alternative) first = "(" + first + ")";
		if (this.right instanceof Alternative) second = "(" + second + ")";
		return first + second;
	}
	
	@Override
	public String toString() {
		return "Sequence(" + left + ", " + right + ")";
	}
	
	@Override
	public Set<String> getShortestWords(EBNFRules rules, int limit) {
		TreeSet<String> newSet = new TreeSet<String>();
		Set<String> leftSet = this.left.getShortestWords(rules, limit);
		Set<String> rightSet = this.right.getShortestWords(rules, limit);
		// combine leftSet and rightSet
		for (String left : leftSet) {
			for (String right : rightSet) {
				String combined = left + right;
				if (combined.length() <= limit) newSet.add(combined);
			}
		}
		return newSet;
	}
}
