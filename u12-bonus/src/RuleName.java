import java.util.Set;

public class RuleName extends EBNFNode {
	
	private final String name;
	
	public RuleName(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toEBNFString() {
		return "<" + this.name + ">";
	}
	
	@Override
	public String toString() {
		return "RuleName(" + name + ")";
	}
	
	@Override
	public Set<String> getShortestWords(EBNFRules rules, int limit) {
		if (!rules.containsRule(name)) throw new IllegalEBNFDescriptionException();
		return rules.getShortestWords(name, limit);
	}
}
