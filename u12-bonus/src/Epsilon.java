import java.util.Set;
import java.util.TreeSet;

public class Epsilon extends EBNFNode {

	@Override
	public String toEBNFString() {
		return "";
	}
	
	@Override
	public String toString() {
		return "Epsilon()";
	}
	
	@Override
	public Set<String> getShortestWords(EBNFRules rules, int limit) {
		TreeSet<String> newSet = new TreeSet<String>();
		newSet.add(toEBNFString());
		return newSet;
	}
}
