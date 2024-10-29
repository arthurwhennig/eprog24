import java.util.Arrays;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RobotPlacementTest {

    /**
     * Checks whether the array arr contains an element
     *
     * @param arr     An hx2 matrix of robot positions
     * @param element A matrix of length 2 representing the robot position to be found
     * @return true iff element is in arr
     */
    public boolean arrayContains(int[][] arr, int[] element) {
        for (int[] a : arr) {
            if (Arrays.equals(a, element)) return true;
        }
        return false;
    }

	@Test
	public void testFindConflictingRobot(){
		char[][] areaA = {  {'-','-','-','-','R'}, 
							{'-','R','-','-','-'},
							{'-','-','-','R','-'},
							{'-','-','R','-','-'},
							{'-','-','R','-','-'}  };
		int[] resultA = RobotPlacement.findConflictingRobot(areaA);
		int[][] expectedA = { {2,3}, {3,2}, {4,2} };
		assertTrue(arrayContains(expectedA, resultA));
		
		char[][] areaB = {  {'-','-','-','-','R'}, 
							{'-','R','-','-','-'},
							{'-','T','T','R','-'},
							{'R','T','T','-','-'},
							{'-','-','R','-','-'}  };
		int[] resultB = RobotPlacement.findConflictingRobot(areaB);
        assertNull(resultB);
		
		char[][] areaC = {  {'-','-','-','R','-','-','-','-'}, 
							{'-','R','-','-','-','-','-','-'}, 
							{'-','-','-','-','-','-','R','-'}, 
							{'-','-','R','-','-','-','-','-'}, 
							{'-','-','-','-','-','R','-','-'}, 
							{'-','-','-','-','-','-','-','R'}, 
							{'-','-','-','-','R','-','-','-'}, 
							{'R','-','-','-','-','-','-','-'}  };
		int[] resultC = RobotPlacement.findConflictingRobot(areaC);
        assertNull(resultC);

        char[][] areaD = {  {'-','-','R','-','-','-','-','-'}, 
							{'-','-','-','-','-','R','-','-'}, 
							{'-','-','-','-','-','-','-','R'}, 
							{'R','-','-','-','-','-','-','-'}, 
							{'-','-','-','R','-','-','-','-'}, 
							{'-','-','T','T','T','-','R','-'}, 
							{'-','R','T','T','T','-','-','-'}, 
							{'-','-','-','-','R','-','-','-'}  };
		int[] resultD = RobotPlacement.findConflictingRobot(areaD);
		int[][] expectedD = { {3,0}, {4,3}, {5,6}, {6,1}, {7,4} };
		assertTrue(arrayContains(expectedD, resultD));	
	}
	
	@Test
	public void testPlaceRobots() {
		char[][] areaA = {   {'-','-','-','-','-'}, 
							 {'-','-','-','-','-'},
							 {'-','T','T','-','-'},
							 {'-','T','T','-','-'},
							 {'-','-','-','-','-'}  };
		char[][] robotsA = RobotPlacement.placeRobots(areaA);
		char[][] expectedA1 = { {'-','-','-','-','R'}, 
							 	{'-','R','-','-','-'},
							 	{'-','T','T','R','-'},
							 	{'R','T','T','-','-'},
							 	{'-','-','R','-','-'} };
		char[][] expectedA2 = { {'-','-','-','-','R'}, 
							 	{'-','-','R','-','-'},
							 	{'R','T','T','-','-'},
							 	{'-','T','T','R','-'},
							 	{'-','R','-','-','-'} };
		assertTrue(Arrays.deepEquals(robotsA, expectedA1) 
				|| Arrays.deepEquals(robotsA, expectedA2));
		
		char[][] areaB = {   {'-','-','-','-','-'}, 
							 {'-','-','-','-','-'},
							 {'T','T','T','T','T'},
							 {'T','T','T','T','T'},
							 {'-','-','-','-','-'}  };
		char[][] robotsB = RobotPlacement.placeRobots(areaB);
		assertNull(robotsB);
		
		char[][] areaC = {  {'-','-','-','-','-','-','-','-'}, 
							{'-','-','-','-','-','-','-','-'}, 
							{'-','-','-','-','-','-','-','-'}, 
							{'-','-','-','-','-','-','-','-'}, 
							{'-','-','-','-','-','-','-','-'}, 
							{'-','T','T','T','T','-','-','-'}, 
							{'-','T','T','T','T','-','-','-'}, 
							{'-','T','T','T','T','-','-','-'}  };
		char[][] robotsC = RobotPlacement.placeRobots(areaC);
		char[][] expectedC = {  {'-','-','-','-','R','-','-','-'}, 
								{'-','R','-','-','-','-','-','-'}, 
								{'-','-','-','R','-','-','-','-'}, 
								{'-','-','-','-','-','-','R','-'}, 
								{'-','-','R','-','-','-','-','-'}, 
								{'-','T','T','T','T','-','-','R'}, 
								{'-','T','T','T','T','R','-','-'}, 
								{'R','T','T','T','T','-','-','-'}  };
		assertArrayEquals(expectedC, robotsC);
		
		char[][] areaD = {  {'-','-','-','-','-','-','-','-','-','-'}, 
							{'-','-','-','-','-','-','-','-','-','-'}, 
							{'-','-','T','T','T','T','T','T','T','-'}, 
							{'-','-','T','T','T','T','T','T','T','-'}, 
							{'-','-','T','T','T','T','T','T','T','-'},  
							{'-','-','-','-','-','-','-','-','-','-'}, 
							{'-','-','-','-','-','-','-','-','-','-'}, 
							{'-','-','-','-','-','-','-','-','-','-'}, 
							{'-','-','-','-','-','-','-','-','-','-'}, 
							{'-','-','-','-','-','-','-','-','-','-'}  };
		char[][] robotsD = RobotPlacement.placeRobots(areaD);
		char[][] expectedD1 = { {'-','-','-','-','-','-','-','-','R','-'}, 
								{'-','-','-','-','-','R','-','-','-','-'}, 
								{'-','R','T','T','T','T','T','T','T','-'}, 
								{'-','-','T','T','T','T','T','T','T','R'}, 
								{'R','-','T','T','T','T','T','T','T','-'},  
								{'-','-','-','-','-','-','R','-','-','-'}, 
								{'-','-','-','R','-','-','-','-','-','-'}, 
								{'-','-','-','-','-','-','-','R','-','-'}, 
								{'-','-','R','-','-','-','-','-','-','-'}, 
								{'-','-','-','-','R','-','-','-','-','-'}  };
		char[][] expectedD2 = { {'-','-','-','-','-','-','-','R','-','-'}, 
								{'-','-','-','-','R','-','-','-','-','-'}, 
								{'-','R','T','T','T','T','T','T','T','-'}, 
								{'-','-','T','T','T','T','T','T','T','R'}, 
								{'R','-','T','T','T','T','T','T','T','-'},  
								{'-','-','-','-','-','R','-','-','-','-'}, 
								{'-','-','-','R','-','-','-','-','-','-'}, 
								{'-','-','-','-','-','-','-','-','R','-'}, 
								{'-','-','-','-','-','-','R','-','-','-'}, 
								{'-','-','R','-','-','-','-','-','-','-'}  };
		char[][] expectedD3 = { {'-','-','R','-','-','-','-','-','-','-'}, 
								{'-','-','-','-','-','R','-','-','-','-'}, 
								{'-','R','T','T','T','T','T','T','T','-'}, 
								{'-','-','T','T','T','T','T','T','T','R'}, 
								{'R','-','T','T','T','T','T','T','T','-'},  
								{'-','-','-','-','-','-','-','-','R','-'}, 
								{'-','-','-','-','R','-','-','-','-','-'}, 
								{'-','-','-','-','-','-','-','R','-','-'}, 
								{'-','-','-','R','-','-','-','-','-','-'}, 
								{'-','-','-','-','-','-','R','-','-','-'}  };
		assertTrue(Arrays.deepEquals(robotsD, expectedD1) 
				|| Arrays.deepEquals(robotsD, expectedD2)
				|| Arrays.deepEquals(robotsD, expectedD3));	
	}
	
	@Test
	public void testPlaceOtherRobots() {
		char[][] areaA = {   {'-','-','-','-','-'}, 
							 {'-','-','-','-','-'},
							 {'R','T','T','-','-'},
							 {'-','T','T','R','-'},
							 {'-','-','-','-','-'}  };
		char[][] robotsA = RobotPlacement.placeOtherRobots(areaA);
		char[][] expectedA = {   {'-','-','-','-','R'}, 
								 {'-','-','R','-','-'},
								 {'R','T','T','-','-'},
								 {'-','T','T','R','-'},
								 {'-','R','-','-','-'}  };
		assertArrayEquals(expectedA, robotsA);

		char[][] areaB = {   {'-','-','-','-','-'}, 
							 {'-','-','-','R','-'},
							 {'-','T','T','-','-'},
							 {'-','T','T','-','-'},
							 {'-','-','-','-','-'}  };
		char[][] robotsB = RobotPlacement.placeOtherRobots(areaB);
		assertNull(robotsB);
		
		char[][] areaC = {  {'-','-','-','-','-','-'}, 
							{'-','-','-','-','-','-'}, 
							{'R','T','T','T','T','-'}, 
							{'-','T','T','T','T','R'}, 
							{'-','-','-','-','-','-'}, 
							{'-','-','-','-','-','-'}  };
		char[][] robotsC = RobotPlacement.placeOtherRobots(areaC);
		char[][] expectedC = {  {'-','-','-','-','R','-'}, 
								{'-','-','R','-','-','-'}, 
								{'R','T','T','T','T','-'}, 
								{'-','T','T','T','T','R'}, 
								{'-','-','-','R','-','-'}, 
								{'-','R','-','-','-','-'}  };
		assertArrayEquals(expectedC, robotsC);
		
		char[][] areaD = {  {'-','-','-','-','-','-','-'},
							{'-','-','-','-','-','-','R'},
							{'-','-','-','-','R','-','-'},
							{'-','-','T','T','T','-','-'},
							{'-','-','T','T','T','-','-'},
							{'R','-','T','T','T','-','-'},
							{'-','-','-','-','-','-','-'}  };
		char[][] robotsD = RobotPlacement.placeOtherRobots(areaD);
		char[][] expectedD = {  {'-','-','-','R','-','-','-'},
								{'-','-','-','-','-','-','R'},
								{'-','-','-','-','R','-','-'},
								{'-','R','T','T','T','-','-'},
								{'-','-','T','T','T','R','-'},
								{'R','-','T','T','T','-','-'},
								{'-','-','R','-','-','-','-'} };
		assertArrayEquals(expectedD, robotsD);
	}
}
