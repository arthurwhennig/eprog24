import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class EBNFRules implements EBNFString {

	private final Map<String, EBNFNode> rules;

	public EBNFRules(Map<String, EBNFNode> rules) {
		this.rules = rules;
	}

	@Override
	public String toEBNFString() {
		TreeMap<String, EBNFNode> sorted = new TreeMap<String, EBNFNode>();
		for (Map.Entry<String, EBNFNode> entry : rules.entrySet()) {
			sorted.put(entry.getKey(), entry.getValue());
		}
		String result = "";
		for (Map.Entry<String, EBNFNode> entry : sorted.entrySet()) {
			String line = "<" + entry.getKey() + "><-" + entry.getValue().toEBNFString() + "\n";
			result = result + line;
		}
		return result;
	}

	public Set<String> getShortestWords(String name, int limit) {
		EBNFNode node = rules.get(name);
		if (node == null) throw new IllegalEBNFDescriptionException();
		return node.getShortestWords(this, limit);
	}
	
	public boolean containsRule(String name) {
		return rules.containsKey(name);
	}
}
