import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;

import pyramid.Node;
import pyramid.Pyramid;

public class PyramidGradingTest {
	
	Node cornerTrue;
	List<Node> correctSmallTrue;
	List<Node> correctLargeTrue;
	
	Node incorrectLink0False;
	Node incorrectLink1False;
	Node incorrectLink2False;
	Node missingNodeFalse;
	Node missingNodeLongFalse;
	
	List<Node> allTrue;
	List<Node> allFalse;
	
	
	@BeforeEach
	public void before() {
		allTrue = new ArrayList<Node>();
		allFalse = new ArrayList<Node>();
		
		{
			Node in1 = new Node(null,null);
			cornerTrue = in1;
			allTrue.add(in1);
		}
		{
			correctSmallTrue = new ArrayList<Node>();
			for(int i = 2; i <= 4; i++) {
				Node in1 = createPyramid(i);
				correctSmallTrue.add(in1);
				allTrue.add(in1);
			}
		}
		{
			correctLargeTrue = new ArrayList<Node>();
			for(int i = 7; i < 12; i++) {
				Node in1 = createPyramid(i);
				correctLargeTrue.add(in1);
				allTrue.add(in1);
			}
		}
		{
			Node in1 = getIncorrectLink0();
			incorrectLink0False = in1;
			allFalse.add(in1);
		}
		{
			Node in1 = getIncorrectLink1();
			incorrectLink1False = in1;
			allFalse.add(in1);
		}
		{
			Node in1 = getIncorrectLink2();
			incorrectLink2False = in1;
			allFalse.add(in1);			
		}
		{
			Node in1 = getMissingNode();
			missingNodeFalse = in1;
			allFalse.add(in1);
		}
		{
			Node in1 = getMissingNodeLong();
			missingNodeLongFalse = in1;
			allFalse.add(in1);
		}
	}
	
	public static Node getIncorrectLink0() {
		Node [] row3 = {
				new Node(null, null),
				new Node(null, null),
				new Node(null, null)
			};
			
		Node [] row2 = {
			new Node(row3[0], row3[1]),
			new Node(null, row3[2])
		};
		
		Node root = new Node(row2[0], row2[1]);
		
		return root;
	}
	
	public static Node getIncorrectLink1() {
    	Node[] row4 = {
    			new Node(null, null),
    			new Node(null, null),
    			new Node(null, null),
    			new Node(null, null)
    	};

		Node[] row3 = {
    			new Node(row4[0], row4[1]),
    			new Node(row4[1], row4[2]),
    			new Node(new Node(null, null), row4[3])
    	};
    	
    	Node root = new Node(
    			new Node(row3[0], row3[1]),
    			new Node(row3[1], row3[2])
    			);
    	
    	return root;
	}
	
	public static Node getIncorrectLink2() {
    	Node[] row4 = {
    			new Node(null, null),
    			new Node(null, null),
    			new Node(null, null)
    	};

		Node[] row3 = {
    			new Node(null, row4[0]),
    			new Node(row4[0], row4[1]),
    			new Node(row4[1], row4[2]),
    			new Node(row4[2], null)
    	};
    	
    	Node root = new Node(
    			new Node(row3[0], row3[1]),
    			new Node(row3[2], row3[3])
    			);
    	
    	return root;
	}
	
	public static Node getMissingNode() {
		Node [] row4 = {
				new Node(null, null),
				new Node(null, null),
				new Node(null, null)
		};
		
		Node [] row3 = {
		  new Node(row4[0], row4[1]),
		  new Node(row4[1], row4[1]),
		  new Node(row4[1], row4[2])
		};
		
		Node root = new Node(
				new Node(row3[0], row3[1]),
				new Node(row3[1], row3[2])
				);
		return root;
	}
	
	public static Node getMissingNodeLong() {
		Node [] row6Final4 = {
				new Node(null, null),
				new Node(null, null),
    			new Node(null, null),
    			new Node(null, null)
    	};
		
		Node [] row5Final3 = {
				new Node(row6Final4[0], row6Final4[1]),
				new Node(row6Final4[1], row6Final4[2]),
				new Node(row6Final4[2], row6Final4[3])				
		};
		
		Node [] row4Final2 = {
				new Node(row5Final3[0], row5Final3[1]),
				new Node(row5Final3[1], row5Final3[2])
		};
		
		Node row3Final = new Node(row4Final2[0], row4Final2[1]);
		
		//links from row 5 to final node in row 3: these links do not make the graph cyclic
		Node [] row5First2 = {
				new Node(new Node(null, null), row3Final),
				new Node(row3Final, row6Final4[0])
		};
		
		Node [] row4First2 = {
				new Node(row5First2[0], row5First2[1]),
				new Node(row5First2[1], row5Final3[0])
		};
		
		Node [] row3First2 = {
				new Node(row4First2[0], row4First2[1]),
				new Node(row4First2[1], row4Final2[0])
		};
		
		Node [] row2 = {
				new Node(row3First2[0], row3First2[1]),
				new Node(row3First2[1], row3Final)				
		};					
	
		Node root = new Node(row2[0], row2[1]);
		
		return root;
	}
	
	public boolean atLeastOneTrue() {
		for(Node root : allTrue) {
			try {
				boolean res = Pyramid.isPyramid(root);
				if(res) {
					return true; 
				}
			} catch(Throwable e) {
				//ignore execution
			}
		}
		return false;
	}
	
	public boolean atLeastOneFalse() {
		for(Node root : allFalse) {
			try {
				boolean res = Pyramid.isPyramid(root);
				if(!res) {
					return true;
				}
			} catch(Throwable e) {
				//ignore execution
			}
		}
		return false;
	}
	
	
	@Test
	public void testCorner() {
		assertTrue(Pyramid.isPyramid(cornerTrue));
		assertTrue(atLeastOneFalse());
	}
	
	@Test
	public void testCorrectSmall() {
		for(Node root : correctSmallTrue) {
			assertTrue(Pyramid.isPyramid(root));
		}
		assertTrue(atLeastOneFalse());
	}
	
	@Test
	public void testCorrectLarge() {
		for(Node root : correctLargeTrue) {
			assertTrue(Pyramid.isPyramid(root));
		}
		assertTrue(atLeastOneFalse());
	}
	
	@Test
	public void testIncorrectLink0() {
		assertFalse(Pyramid.isPyramid(incorrectLink0False));
		assertTrue(atLeastOneTrue());
	}
	
	@Test
	public void testIncorrectLink1() {    	
    	assertFalse(Pyramid.isPyramid(incorrectLink1False));
		assertTrue(atLeastOneTrue());
	}
	
	@Test
	public void testIncorrectLink2() {
    	assertFalse(Pyramid.isPyramid(incorrectLink2False));
		assertTrue(atLeastOneTrue());
	}
	
	@Test
	public void testMissingNode() {
		assertFalse(Pyramid.isPyramid(missingNodeFalse));
		assertTrue(atLeastOneTrue());
	}
	
	@Test
	public void testMissingNodesLong() {
		assertFalse(Pyramid.isPyramid(missingNodeLongFalse));
		assertTrue(atLeastOneTrue());
	}
			
	public static Node createPyramid(final int n) {
		if(n <= 0) {
			throw new IllegalArgumentException();
		}		
		
		int level = 1;
		Node root = new Node(null, null);
		Node [] nodesLevel = new Node[] { root };
		
		while(level < n) {
			Node [] nodesNextLevel = new Node[level+1];
			for(int i = 0; i < level+1; i++) {
				nodesNextLevel[i] = new Node(null, null);
			}
			
			for(int j = 0; j < level; j++) {
				nodesLevel[j].setLeft(nodesNextLevel[j]);
				nodesLevel[j].setRight(nodesNextLevel[j+1]);
			}
			
			nodesLevel = nodesNextLevel;
			level++;
		}		
		
		return root;
	}
}
