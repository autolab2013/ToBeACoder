import java.util.ArrayList;


public class HARMA {
	
	public static void main(String[] args){
//		getConsecutiveSums(150);
		testSolvePath();
		return;
	}
	
	/**
	 * Implement method getConsecutiveSums(int n) that returns an array of all arrays of consecutive
	 * positive numbers that sum to n. Because the numbers are consecutive, each array can
	 * be represented by only the first and last numbers. For example, to represent the array [1, 2,3, 4, 5], 
	 * only [1, 5] is needed. The order of the arrays should be ascending in their actual sizes.
	 * Example: getConsecutiveSums(15) should return array [[15, 15], [7, 8], [4, 6],[1, 5]] as the result.
	 */
	public static ArrayList<int[]> getConsecutiveSums(int n){
		ArrayList<int[]> result = new ArrayList<int[]>();
		for(int i=n;i>0;i--){
			if((2*n)%i == 0){
				int x = (2*n)/i;
				if(x > i-1 && (x-i+1)%2 == 0){
					int start = (x-i+1)/2;
					int end = start + i-1;
					int[] arr = {start, end};
					result.add(arr);
				}
			}
		}
		for(int i= 0; i<result.size(); i++){
			System.out.println(result.get(i)[0]);
			System.out.println(result.get(i)[1]);
		}
		return result;
	}
	
	/**
	 * Implement method solvePath(boolean[][] maze, Point start, Point end) that returns
	 * true if a path exists between the start and end points, and false otherwise. A true in
	 * the maze indicates that traveling through that position is permitted, while a false indicates a
	 * wall. Point is a class containing two fields x and y representing a coordinate in the maze such
	 * that the upper-right position of the maze is at coordinate (maze[0].length - 1, 0). A path
	 * is defined as a sequence of maze coordinates where each coordinate refers to a true position,
	 * and the position immediately before or after any given position in the sequence must be one of
	 * the up-to-four neighbors of the given position.
	 */
	public static boolean solvePath(boolean[][] maze, Point start, Point end){
		if(Point.isConnected(start, end, maze.length))
			return true;
		if(start.x -1 >= 0 && maze[start.y][start.x-1] )
			return solvePath(maze, new Point(start.x-1, start.y, maze.length), end);
		if(start.x +1 <= maze.length && maze[start.y][start.x+1])
			return solvePath(maze, new Point(start.x+1, start.y, maze.length), end);
		if(start.y -1 >= 0 && maze[start.y-1][start.x])
			return solvePath(maze, new Point(start.x, start.y-1, maze.length), end);
		if(start.y +1 < maze.length && maze[start.y+1][start.x])
			return solvePath(maze, new Point(start.x, start.y+1, maze.length), end);
		return false;
	}
	
	public static void testSolvePath(){
		boolean[][] maze = {{false ,false ,true}, {false, true, false}, {true, false ,false }};
		Point start = new Point(0,0, maze.length);
		Point end = new Point(2,2, maze.length);
		System.out.println(solvePath(maze, start, end));
	}
	
	/**
	 * A topological map is a map representing the height of various locations on a terrain. Such a
	 * map can be represented by a two-dimensional array of integers where each number denotes the
	 * height of a location of the terrain.
	 * Each topological map defines a watershed, an area of land where surface water from rain and
	 * melting snow or ice converges to a single point at a lower elevation1. In our setting, surface
	 * water at any given location always flows to the lowest of its up-to-four neighbors that is also
	 * lower than it. When two or more of these neighbors have the same lowest height, water can flow
	 * to any of them, and the given location could be part of multiple watersheds.
	 * The size of a watershed is defined as the number of locations of the terrain for which surface
	 * water flows to the same contiguous region of the terrain. (See examples below.)
	 * Implement method getWatershedSizes(int[][] topo) that takes a topological map of a
	 * piece of terrain and returns an array of sizes of all its watersheds in descending order.
	 * Examples:
	 * 1 2 3 4 1
	 * This terrain contains two watersheds of size 3 and 2. The larger watershed consists of the three
	 * leftmost locations. The smaller watershed consists of the two rightmost ones. Surface water at
	 * elevation 4 flows to the east because elevation 1 is lower than elevation 3. The method should
	 * return array [3, 2].
	 * 1 2 3 4 3
	 * This terrain contains two watersheds of size 4 and 2. The larger watershed now includes the
	 * location at elevation 4, where the surface water can flow either to the east or to the west. The
	 * method should return array [4, 2].
	 */
	public static ArrayList<Integer> getWatershedSizes(int[][] topo){
		ArrayList<Integer> result = new ArrayList<Integer>();
		return result;
	}

}
