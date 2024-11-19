
public class GraphExecution {
	public static LinkedProgramStateList merge() {
		
		return null;
	}
	
	public static void addResultsFromChildren(Node n, ProgramState state, LinkedProgramStateList results) {
		Node[] children = n.getSubnodes();
		if (n.getType().equals("CHOICE")) {
			for (int i = 0; i < children.length; i++) {
				addResultsFromChildren(children[i], state, results);
				
				if (!children[i].getType().equals("CHOICE")) {
					ProgramState newState = new ProgramState(state.getSum(), state.getCounter());
					results.addLast(newState);
					addResultsFromChildren(children[i], newState, results);
				} else {
					addResultsFromChildren(children[i], state, results);
				}
			}
		} else if (n.getType().equals("SEQ")) {
			// run all deterministic nodes before-hand
			for (int i = 0; i < children.length; i++) {
				if (!children[i].getType().equals("CHOICE")) addResultsFromChildren(children[i], state, results);
			}
			int count = 0;
			for (int i = 0; i < children.length; i++) {
				if (children[i].getType().equals("CHOICE")) {
					count++;
					addResultsFromChildren(children[i], state, results);
				}
			}
			if (count == 0 && results.isEmpty()) {
				results.addFirst(state);
			}
		} else if (n.getType().equals("ADD")) {
			state.sum += n.getValue(); 
			state.counter += 1;
		}
	}
	
	public static LinkedProgramStateList allResults(Node n, ProgramState initState) {
		LinkedProgramStateList results = new LinkedProgramStateList();
		
		if (n.getType().equals("ADD")) {
			addResultsFromChildren(n, initState, results);
			results.addFirst(initState);
		} else {
			addResultsFromChildren(n, initState, results);
		}
		
		return results;
	}

}
