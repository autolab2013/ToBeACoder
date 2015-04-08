/**
 *  4.5 Implement a function to check if a binary tree is a binary search tree.
 */
 
//we cannot simply compare left, root, right at a node,
// we have to remember BST ALL left node < root, ALL right node > root
public boolean isBST(Node root){
	return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

private boolean checkBST(Node root, int min, int max){
	if(root == null) return true;
	if(root < min || root >= max) return false;
	return checkBST(root.left, min, root.value) && checkBST(root.right, root.value, max);
}

//we can inorder traverse the tree and make sure the next node is no less than previous one

public boolean isBST(Node root){
	return isBST(root, new Integer(Integer.MIN_VALUE));
}

private boolean isBST(Node root, Integer prev){
	if(root == null) return true;
	boolean left = isBST(root.left, prev);
	if(prev > root.value || !left) return false;
	prev = root.value;
	boolean right = isBST(root.right, prev);
	return right;
}
