/**
 *  4.1 Implement a function to check if a binary tree is balanced. For the purpose of
 *  this question, a balanced tree is defined to be a tree such that the heights of the two
 *  subtrees of any node never differ by more than one.
 */
 
public boolean isBalanced(Node root){
	if(root == null) return true;
	if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
		return false;
	return isBalanced(root.left) && isBalanced(root.right);
}

private int getHeight(Node root){
	if(root == null) return 0;
	//DFS
	int left = getHeight(root.left) + 1;
	int right = getHeight(root.right) + 1;
	return Math.max(left, right);
}

/**
 *  avoid call getHeight on a node many times:
 */
 
 //can add a new field "height" to Node, initialize height by all getHeight(root), then get node height is O(1)
 //getHeigth() is O(n), isBalanced is O(n)
 
 //check in getHeight()
 //if not balanced, return -1;
private int getHeight(Node root){
	if(root == null) return 0;
	int left = getHeight(root.left);
	if(left == -1) return -1;
	int right = getHeight(root.right);
	if(right == -1) return -1;
	if(Math.abs(left - right) > 1) return -1;
	return Math.max(left, right) + 1;
}

public boolean isBlanced(Noee root){
	if(getHeight(root) != -1)
		return true;
	return false;
}