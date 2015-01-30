/** 9.2 Imagine a robot sitting on the upper left corner of an X by Y grid.
 *  The robot can only move in two directions: right and down. How many possible
 *  paths are there for the robot to go from (0, 0) to (X, Y)?
 *  
 *  FOLLOW UP
 *  Imagine certain spots are "off limits", such that the robot cannot step on them.
 *  Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
 
/** I think
 *  
 */
 //Node has x and y field, both are int
public static int countPaths(int curr_x, int curr_y){
	if(curr_x == 0 && curr_y == 0)
		return 1;
	else if(curr_x == 0)
		return countPaths(0, curr_y-1);
	else if(curr_y == 0)
		return countPaths(curr_x - 1, 0);
	else
		return countPaths(curr_x-1, curr_y) + countPaths(curr_x, curr_y-1) ;
}