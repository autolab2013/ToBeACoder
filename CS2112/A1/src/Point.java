
public class Point {
	int x;
	int y;
	int size;
	
	public Point(int a, int b, int c){
		x = a;
		y = b;
		size = c;
	}
	
	public static boolean isConnected(Point a, Point b, int size){
		Point left = new Point(a.x-1, a.y, size);
		Point right = new Point(a.x+1, a.y, size);
		Point up = new Point(a.x, a.y-1, size);
		Point down = new Point(a.x, a.y+1, size);
		return b.equals(left) || b.equal(right) || b.equal(up) || b.equal(down);
	}
	
	public boolean equal(Point c){
		return x == c.x && y == c.y;
	}

}
