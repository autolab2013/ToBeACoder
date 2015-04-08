/**
 *  4.9 You are given a binary tree in which each node contains an integer value(which
 *  might be positive or negative). Design an alg to print all paths which sum to 
 *  a given value. The path does not need to start or end at the root or a leaf, but it must
 *  go in a straight line down.
 */
 
public void findPath(Node root, int value){
	Node[] path = new Node[depth(root)];
	findPath(root, path, value, 0);
}

private int depth(Node root){
	if(root == null) return 0;
	return 1 + depth(root.left) + depth(root.right);
}

private void findPath(Node root, Node[] path, int value, int level){
	if(node == null) return;
	path[level] = root;
	int sum = 0;
	for(int i=level; i>=0; i--){
		sum += path[level].value;
		if(sum == value) buidlPath(path, i, level);//store path somewhere
	}
	findPath(root.left, path, value, level);
	findPath(root.right, path, value, level);
}