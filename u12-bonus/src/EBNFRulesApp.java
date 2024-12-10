import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EBNFRulesApp {
	
	public static void main(String[] args) {
		
		System.out.println("Part a)");
		System.out.println();
		
		EBNFNode node1 = new Option(new Literal('A'));
		System.out.println(node1.toEBNFString());
		EBNFNode node2 = new Sequence(new Literal('B'), new Literal('C'));
		System.out.println(node2.toEBNFString());
		EBNFNode node3 = new Alternative(new RuleName("ab"), new Literal('D'));
		System.out.println(node3.toEBNFString());
		EBNFNode node4 = new Repetition(new Brackets(new Epsilon()));
		System.out.println(node4.toEBNFString());
		EBNFNode node5 = new Sequence(new Literal('E'), new Alternative(new Literal('F'), new Literal('G')));
		System.out.println(node5.toEBNFString());
		
		System.out.println();
		
		Map<String,EBNFNode> map1 = new TreeMap<String,EBNFNode>();
		map1.put("ab", node1);
		map1.put("a", node2);
		map1.put("aa", node3);
		map1.put("b", node4);
		EBNFRules rules1 = new EBNFRules(map1);
		System.out.println(rules1.toEBNFString().replace("\r", "").trim());
		
		System.out.println();
		System.out.println("Part b)");
		System.out.println();
		
		Map<String,EBNFNode> map2 = new HashMap<String,EBNFNode>();
		map2.put("xrule", new Alternative(new Literal('X'), new Literal('Q')));
		map2.put("yrule", new Repetition(new Literal('Y')));
		map2.put("zrule", new Sequence(new Literal('Z'), new RuleName("yrule")));
		map2.put("qrule", new RuleName("house"));
		EBNFRules rules2 = new EBNFRules(map2);
		
		System.out.println(rules2.getShortestWords("xrule", 1));
		System.out.println(rules2.getShortestWords("yrule", 3));
		System.out.println(rules2.getShortestWords("zrule", 4));
		try {
			System.out.println(rules2.getShortestWords("tree", 5));
		} catch(IllegalEBNFDescriptionException e) {
			System.out.println("throws IllegalEBNFDescriptionException");
		}
		try {
			System.out.println(rules2.getShortestWords("qrule", 7));
		} catch(IllegalEBNFDescriptionException e) {
			System.out.println("throws IllegalEBNFDescriptionException");
		}
		
	}
	
}
