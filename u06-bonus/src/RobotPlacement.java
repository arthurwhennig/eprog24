import java.util.Arrays;
import java.util.ArrayList;

public class RobotPlacement {
	
	
	public static void main(String[] args) {
		char[][] areaA = {
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','T','T','T','T','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','T','T','T','T','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','T','T','T','T','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
				{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},			
	};
		char[][] area = placeRobots(areaA);
		System.out.println(Arrays.deepToString(area));
		
	}
	
	// check if there are conflicts within the given robots
	public static Integer[] getConflict(ArrayList<Integer[]> robots) {
		for (int i = 0; i < robots.size(); i++) {
			Integer[] curr = robots.get(i);
			for (int j = i+1; j < robots.size(); j++) {
				Integer[] other = robots.get(j);
				if (curr[0] == other[0] || curr[1] == other[1]) { // horizontal and vertical check
					return other;
				}
				if (curr[0] - curr[1] == other[0] - other[1] || curr[0] + curr[1] == other[0] + other[1]) { // diagonal check
					return other;
				}
			}
		}
		return null;
	}
	
	// Find the positions of all items in the given area
	public static ArrayList<Integer[]> findItems(char[][] area, char item) {
		ArrayList<Integer[]> items = new ArrayList<Integer[]>();
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area.length; j++) {
				if (area[i][j] == item) {
					items.add(new Integer[]{i, j});
				}
			}
		}
		return items;
	}

	// Find a robot that blocks other robots' laser light
	public static int[] findConflictingRobot(char[][] area) {
		ArrayList<Integer[]> robots = findItems(area, 'R');
		Integer[] conflict = getConflict(robots);
		if (conflict == null) return null;
		return new int[] { conflict[0], conflict[1] };
	}
	
	// Places a new robot into col and return the resulting area
	// Returns null if there is no possible solution without conflicts
	public static char[][] placeNewRobots(char[][] area, int prev, int col) {
		// exit if col is out of bounds
		if (col == area.length) return area;
		for (int i = 0; i < area.length; i++) {
			char curr = area[i][col];
			// skip the entire column if there is already a robot
			if (curr == 'R') return placeNewRobots(area, i, col+1);
			// skip treasure positions and positions that directly conflict the previously inserted robot
			if (i == prev || i == prev+1 || i == prev-1 || curr == 'T') continue;
			// insert the robot
			area[i][col] = 'R';
			// continue recursively if there are no conflicts with the new robot
			if (findConflictingRobot(area) == null) {
				char[][] newArea = placeNewRobots(area, i, col+1);
				if (newArea != null) return newArea;
			}
			// delete the robot if there is no recursive solution for newArea
			area[i][col] = curr;
		}
		return null;
	}

	// Place h robots in an h*h area to protect the treasure
	public static char[][] placeRobots(char[][] area) {
		return placeNewRobots(area, -2, 0);
	}

	// Place other robots with pre-installed robots in an h*h area to protect the treasure
	public static char[][] placeOtherRobots(char[][] area) {
		return placeNewRobots(area, -2, 0);
	}

}