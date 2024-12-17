import java.util.Set;
import java.util.TreeSet;

public class Alternative extends EBNFNode {

	private final EBNFNode first, second;
	
	public Alternative(EBNFNode first, EBNFNode second) {
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public String toEBNFString() {
		return this.first.toEBNFString() + "|" + this.second.toEBNFString();
	}
	
	@Override
	public String toString() {
		return "Alternative(" + first + ", " + second + ")";
	}

	@Override
	public Set<String> getShortestWords(EBNFRules rules, int limit) {
		TreeSet<String> newSet = new TreeSet<String>();
		Set<String> firstSet = this.first.getShortestWords(rules, limit);
		Set<String> secondSet = this.second.getShortestWords(rules, limit);
		
		for (String s : firstSet) if (s.length() <= limit) newSet.add(s);
		for (String s : secondSet) if (s.length() <= limit) newSet.add(s);
		
		return newSet;
	}
}
