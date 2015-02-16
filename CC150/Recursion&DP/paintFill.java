/** 9.7 Implement the "paint fill" function that one might see on many image editing
 *  programs. That is, given a screen(represented by a two-dimensional array of colors),
 *  a point and a new color, fill in the surrounding area until the color changes from the
 *  original color.
 */
 
//8:47PM

/** I think
 *  fill the pixels around a given point? 
 *  Should be get a point and its color, fill all the pixels accessible from this point with the same color
 *  use BFS
 */
 
public static void paintFill(int[][] screen, Point pt, String new_color){
	//base case:
	//if curr.color != given pt.color, do nothing
	//else change it to new color, find the pt.up/down/left/right
	paintFill(screen, pt, new_color, pt.color);
	
}

public static void paintFill(int[][] screen, Point next_pt, String new_color, String curr_color){
	if( pt == null ||pt.color != curr_color)
		return;
	pt.setColor(new_color);
	paintFill(screen, pt.getLeft(), new_color, curr_color);
	paintFill(screen, pt.getRight(), new_color, curr_color);
	paintFill(screen, pt.getUp(), new_color, curr_color);
	paintFill(screen, pt.getDown(), new_color, curr_color);
}

class Point{
	private int x;
	private int y;
	private String color;
	private max_x = 100;
	private max_y = 100;
	private int[][] screen;
	
	public Point(int new_x, int new_y, Color c){
		x= new_x;
		y = new_y;
		color = c;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public void setColor(String c){
		this.color = c;
	}
	
	public Point getLeft(){
		if(this.x >0)
			return new Point(this.x-1, this.y, screen[this.x-1][this.y]);
		return null;
	}
	
	public Point getRight(){
		if(this.x < max_x-1)
			return new Point(this.x+1, this.y, screen[this.x+1][this.y]);
		return null;
	}
	
	public Point getUp(){
		if(this.y >0)
			return new Point(this.x, this.y-1, screen[this.x][this.y-1]);
		return null;
	}
	
	public Point getDown(){
		if(this.y <max_y-1)
			return new Point(this.x, this.y+1, screen[this.x][this.y+1]);
		return null;
	}
} 

//9:07PM

/** Book Solution
 *  Be careful that for screen[][], if (x,y), then corresponding element in screen is screen[y][x]!!!
 *  actually I am using DFS, BFS should use a queue to enqueue neighbors:
 *  search left/right/up/down, if not null && same color, add to queue
 */