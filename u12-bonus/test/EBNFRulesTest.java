import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.*;

import org.junit.jupiter.api.Test;

public class EBNFRulesTest {
	@Test
	public void testToEBNFString1() {
		EBNFNode node1 = new Option(new Literal('A'));
		assertEquals("[A]", node1.toEBNFString());
	}
	
	@Test
	public void testToEBNFString2() {
		EBNFNode node2 = new Sequence(new Literal('B'), new Literal('C'));
		assertEquals("BC", node2.toEBNFString());
	}
	
	@Test
	public void testToEBNFString3() {
		EBNFNode node3 = new Alternative(new RuleName("ab"), new Literal('D'));
		assertEquals("<ab>|D", node3.toEBNFString());
	}
	
	@Test
	public void testToEBNFString4() {
		EBNFNode node4 = new Repetition(new Brackets(new Epsilon()));
		assertEquals("{()}", node4.toEBNFString());
	}
	
	@Test
	public void testToEBNFString5() {
		EBNFNode node5 = new Sequence(new Literal('E'), new Alternative(new Literal('F'), new Literal('G')));
		assertEquals("E(F|G)", node5.toEBNFString());
	}
	
	@Test
	public void testToEBNFString6() {
		EBNFNode node1 = new Option(new Literal('A'));
		assertEquals("[A]", node1.toEBNFString());
		EBNFNode node2 = new Sequence(new Literal('B'), new Literal('C'));
		assertEquals("BC", node2.toEBNFString());
		EBNFNode node3 = new Alternative(new RuleName("ab"), new Literal('D'));
		assertEquals("<ab>|D", node3.toEBNFString());
		EBNFNode node4 = new Repetition(new Brackets(new Epsilon()));
		assertEquals("{()}", node4.toEBNFString());
		EBNFNode node5 = new Sequence(new Literal('E'), new Alternative(new Literal('F'), new Literal('G')));
		assertEquals("E(F|G)", node5.toEBNFString());
		
		Map<String,EBNFNode> map1 = new TreeMap<String,EBNFNode>();
		map1.put("ab", node1);
		map1.put("a", node2);
		map1.put("aa", node3);
		map1.put("b", node4);
		EBNFRules rules1 = new EBNFRules(map1);
		assertEquals("<a><-BC\n"
				   + "<aa><-<ab>|D\n"
				   + "<ab><-[A]\n"
				   + "<b><-{()}", rules1.toEBNFString().replace("\r", "").trim());
	}
	
	@Test
	public void testGetShortestWords1() {
		Map<String,EBNFNode> map2 = new HashMap<String,EBNFNode>();
		map2.put("xrule", new Alternative(new Literal('X'), new Literal('Q')));
		map2.put("yrule", new Repetition(new Literal('Y')));
		map2.put("zrule", new Sequence(new Literal('Z'), new RuleName("yrule")));
		map2.put("qrule", new RuleName("house"));
		EBNFRules rules2 = new EBNFRules(map2);
		
		assertEquals(Set.of("X", "Q"), rules2.getShortestWords("xrule", 1));
	}

	@Test
	public void testGetShortestWords2() {
		Map<String,EBNFNode> map2 = new HashMap<String,EBNFNode>();
		map2.put("xrule", new Alternative(new Literal('X'), new Literal('Q')));
		map2.put("yrule", new Repetition(new Literal('Y')));
		map2.put("zrule", new Sequence(new Literal('Z'), new RuleName("yrule")));
		map2.put("qrule", new RuleName("house"));
		EBNFRules rules2 = new EBNFRules(map2);
		
		assertEquals(Set.of("", "Y", "YY", "YYY"), rules2.getShortestWords("yrule", 3));
	}
	
	@Test
	public void testGetShortestWords3() {
		Map<String,EBNFNode> map2 = new HashMap<String,EBNFNode>();
		map2.put("xrule", new Alternative(new Literal('X'), new Literal('Q')));
		map2.put("yrule", new Repetition(new Literal('Y')));
		map2.put("zrule", new Sequence(new Literal('Z'), new RuleName("yrule")));
		map2.put("qrule", new RuleName("house"));
		EBNFRules rules2 = new EBNFRules(map2);

		assertEquals(Set.of("Z", "ZY", "ZYY", "ZYYY"), rules2.getShortestWords("zrule", 4));
	}
	
	@Test
	public void testGetShortestWords4() {
		Map<String,EBNFNode> map2 = new HashMap<String,EBNFNode>();
		map2.put("xrule", new Alternative(new Literal('X'), new Literal('Q')));
		map2.put("yrule", new Repetition(new Literal('Y')));
		map2.put("zrule", new Sequence(new Literal('Z'), new RuleName("yrule")));
		map2.put("qrule", new RuleName("house"));
		EBNFRules rules2 = new EBNFRules(map2);

		assertThrows(IllegalEBNFDescriptionException.class, ()->rules2.getShortestWords("tree", 5));
	}
	
	@Test
	public void testGetShortestWords5() {
		Map<String,EBNFNode> map2 = new HashMap<String,EBNFNode>();
		map2.put("xrule", new Alternative(new Literal('X'), new Literal('Q')));
		map2.put("yrule", new Repetition(new Literal('Y')));
		map2.put("zrule", new Sequence(new Literal('Z'), new RuleName("yrule")));
		map2.put("qrule", new RuleName("house"));
		EBNFRules rules2 = new EBNFRules(map2);

		assertThrows(IllegalEBNFDescriptionException.class, ()->rules2.getShortestWords("qrule", 7));
	}
	
}
