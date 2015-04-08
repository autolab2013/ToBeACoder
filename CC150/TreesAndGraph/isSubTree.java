/**
 *  4.8 You have two very large binary tree: T1, with millions of nodes, and T2, with 
 *  hundreds of nodes. Create an alg to decide if T2 is a subtree of T1.
 *  
 *  A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n
 *  is identical to T2. That is, if you cut off the tree at node n, the two trees would be
 *  identical.
 */
 
public boolean isSubTree(Node root1, Node root2){
	if(root1 == null) return false;
	if(root2 == null) return true;
	if(root1.equals(root2)){
		if(isExactTree(root1, root2)) return true;
	}
	return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
}

private boolean isExactTree(Node root1, Node root2){
	if(root1 == null){
		return root2 == null;
	}else if(!root1.equals(root2)) return false;
	return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
}