import java.util.Map;
import java.util.Set;

public class EBNFRules implements EBNFString {

	private final Map<String, EBNFNode> rules;

	public EBNFRules(Map<String, EBNFNode> rules) {
		this.rules = rules;
	}

	@Override
	public String toEBNFString() {
		// TODO task a
		
		return null;
	}

	public Set<String> getShortestWords(String name, int limit) {
		// TODO task b

		return null;
	}
}
