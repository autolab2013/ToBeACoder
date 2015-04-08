/**
 *  4.7 Design an alg and write code to find the first common ancestor of two nodes
 *  in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 *  necessarily a binary search tree.
 */
 
//suppose n1, n2 are both in the tree
public Node findAncestor(Node root, Node n1, Node n2){
	//TODO: can improve
	if(root == null) return null;
	if(root == n1 || root == n2) return root;
	boolean left1 = find(root.left, n1);
	boolean left2 = find(root.left, n2);
	if(left1 == left2){
		if(left1) return find(root.left, n1, n2);
		else return find(root.right, n1, n2);
	}return root;
}

private boolean find(Node root, Node n){
	if(root == null) return n == null;
	if(root == n)) return true;
	return find(root.left, n) || find(root.right, n);
}