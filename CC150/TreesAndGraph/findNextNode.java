/** 
 *  4.6 Write an alg to find the 'next' node(i.e. in-order successor) of a given node in
 *  a binary search tree. You may assume that each node has a link to its parent.
 */
 
public Node findNextNode(Node root){
	if(root == null) return null;
	if(root.right != null) return getLeftMost(root);
	else{
		Node parent = root.parent;
		return findParent(parent, root);
	}
}

private Node getLeftMost(Node root){
	if(root == null) return null;
	while(root.left != null){
		root = root.left;
	}
	return root;
}

private Node findParent(Node root, Node child){
	if(root == null) return null;
	if(root.left == child) return parent;
	return findParent(root.parent, child);
}