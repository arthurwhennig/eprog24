import java.util.*;
import java.util.TreeSet;

public class Literal extends EBNFNode {
	
	private final char literal;
	
	public Literal(char literal) {
		super();
		this.literal = literal;
	}
	
	@Override
	public String toEBNFString() {
		return "" + this.literal;
	}

	@Override
	public String toString() {
		return "Literal(" + literal + ")";
	}
	
	@Override
	public Set<String> getShortestWords(EBNFRules rules, int limit) {
		TreeSet<String> newSet = new TreeSet<String>();
		if (toEBNFString().length() <= limit) newSet.add(toEBNFString());
		return newSet;
	}
}
