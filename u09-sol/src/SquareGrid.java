import java.util.LinkedList;

public class SquareGrid {

    public static int analyzeSquareGrid(Node origin) {
    	//A List to check if all nodes are only once in our Grid
    	LinkedList<Node> unique = new LinkedList<Node>();
    	
    	
    	Node cur = origin;
    	int width = 1;
    	int height = 1;
    	
    	//get width of first row
    	while(cur.getRight() != null && !unique.contains(cur.getRight())) {
    		unique.add(cur);
    		width++;
    		cur = cur.getRight();
    	}
    	
    	//get height of first column
    	cur = origin;
    	while( cur.getDown() != null &&!unique.contains(cur.getDown())) {
    		unique.add(cur);
    		height++;
    		cur = cur.getDown();
    	}
    	
    	//get max size for grid based on first row/column 
    	int size = Math.min(width, height);
    	
    	//greate an Array to test the grid
    	Node[][] testGrid = new Node[size][size];
    	
    	//set the Values for fist row/column
    	Node curRow = origin;
    	Node curCol = origin;
    	for(int i = 0; i < size; i++) {
    		testGrid[i][0] = curRow;
    		curRow = curRow.getDown();
    		testGrid[0][i] = curCol;
    		curCol = curCol.getRight();
    	}
    	
    	//Array that contains the max width for column i
    	int[] maxWidth = new int[size];
    	maxWidth[0] = size;
    	
    	
    	for(int i  = 1; i < size; i++) {
    		
    		//set Row with getDown()
    		for(int k = 1; k < size; k++) {
    			//stop if entry null
    			if(testGrid[i-1][k] == null) {
    				break;
    			}
    			else {
    				testGrid[i][k] = testGrid[i-1][k].getDown();
    			}	
    		}
    		//check the grid for correctness with getRight()
    		for(int k = 1; k < size; k++) {
    			//stop if entry is null
    			if(testGrid[i][k] == null) {
    				maxWidth[i] = k;
    				break;
    			}
    			//stop if we seen the same node already in the grid
    			else if(unique.contains(testGrid[i][k])) {
    				maxWidth[i] = k;
    				break;
    			}
    			//stop if it is not a grid
    			else if( testGrid[i][k-1].getRight() != testGrid[i][k]) {
    				maxWidth[i] = k;
    				break;
    			} 
    			maxWidth[i] = k+1;
    			unique.add(testGrid[i][k]);
    		}
    	}
    	
    	//get max grid size starting from origin
    	int result = size;
    	for(int i = 0; i < size; i++) {
    		if(maxWidth[i] < result) {
    			if(i < maxWidth[i]) {
    				result = maxWidth[i];
    			}
    			else {
    				return i;
    			}
    		}
    	}
    	return result;
    }
    
}