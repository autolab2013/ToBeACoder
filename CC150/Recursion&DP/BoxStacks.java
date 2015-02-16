/** 9.10 You have a stack of n boxes, with widths wi, heights hi and depths di. 
 *  The boxes cannot be rotated and can only be stacked on top of one another if
 *  each box in the stack is strictly larger than the box above it in width, heights
 *  and depth. Implement a method to build the tallest stack possible, where the height
 *  of a stack is the sum of the heights of each box.
 */
 
//10:35pm
/** I think
 *  must have a isLarger() func
 *  goal: tallest
 *  get the set of smaller boxes
 *  sort boxes by size
 *  suppose after select n-1 boxes, the next available box is i, try all available boxes until there is none, get max
 *  opt(n) = max{opt(n-1) + height(i)}
 *  greedy? try 0~n boxes as the base, then choose the max height available box =>not optimal 
 */

class Box{
	int width;
	int height;
	int depth;
	
	boolean compareTo(Box b){
		return (width > b.width)&&(height > b.height) && (depth >b.depth);
	}
}
public static void main(String[] args){
	ArrayList<Box> boxes;
	int height =0;
	int tmp = 0;
	for(Box b: boxes){
		tmp = getMaxHeight(0, b);
		if(tmp > height)
			height = tmp;
	}
	return height;
}

public int getMaxHeight(ArrayList<Box> boxes, int height, Box box){
	if(getSmallerBox(boxes, box).isEmpty())
		return height;
	ArrayList<Box> smaller = getSmallerBox(box);
	for(Box b:smaller){
		return (boexes, height+b.height, b);
	}
}

private ArrayList<Box> getSmallerBox(ArrayList<Box> boxes, Box box){
	ArrayList<Box> smaller = new ArrayList<Box>();
	for(Box b:boxes){
		if(box.compareTo(b))
			smaller.add(b);
	}
	return smaller;
}

//10:52
/** book solution
 *  book use cache(HashMap<Box, ArrayList<Box>>) to improve efficiency
 *  here HashMap key Box is the bottom
 */