import java.util.Arrays;

public class RobotPlacement {
	public static void main(String[] args) {
		char[][] areaA = {   {'-','-','-','-','R'}, 
						     {'-','R','-','-','-'},
							 {'-','-','-','R','-'},
							 {'-','-','R','-','-'},
							 {'-','-','R','-','-'}  };
		int[] conflictingRobotsA = findConflictingRobot(areaA);
		System.out.println(Arrays.toString(conflictingRobotsA));
		
		char[][] areaB = {   {'-','-','-','-','-'}, 
							 {'-','-','-','-','-'},
							 {'-','T','T','-','-'},
							 {'-','T','T','-','-'},
							 {'-','-','-','-','-'}  };
		char[][] robotsB = placeOtherRobots(areaB);
		System.out.println(Arrays.deepToString(robotsB));
		
		char[][] areaC = {   {'-','-','-','-','-'}, 
							 {'-','-','-','-','-'},
							 {'R','T','T','-','-'},
							 {'-','T','T','R','-'},
							 {'-','-','-','-','-'}  };
		char[][] robotsC = placeOtherRobots(areaC);
		System.out.println(Arrays.deepToString(robotsC));
	}

	// Find a robot that blocks other robots' laser light
	public static int[] findConflictingRobot(char[][] area) {
		// TODO: Implementieren Sie diese Methode.

		return new int[0];
	}

	// Place h robots in an h*h area to protect the treasure
	public static char[][] placeRobots(char[][] area) {
		// TODO: Implermentieren Sie diese Methode.

		return new char[0][];
	}

	// Place other robots with pre-installed robots in an h*h area to protect the treasure
	public static char[][] placeOtherRobots(char[][] area) {
		// TODO: Implementieren Sie diese Methode.

		return new char[0][];
	}

}