/**
 *  4.4 Given a binary tree, design an alg which creates a linked list of all the nodes at
 *  each depth(e.g., if you have a tree with depth D, you'll have D linked list).
 */
 
public LinkedList<LinkedList<Node>> BinaryTreeToLinkedList(Node root){
	if(root == null) return null;
	LinkedList<LinkedList<Node>> list = new LinkedList<>();
	LinkedList<Node> level = new LinkedList<>();
	level.addLast(root);
	while(!level.isEmpty()){
		list.addLast(new LinkedList<Node>(level));
		LinkedList<Node> next_level = new LinkedList<>();
		for(Node n: level){
			if(n.left != null) next_level.addLast(n.left);
			if(n.right != null) next_level.addLast(n.right);
		}level = next_level;
	}
	return result;
}

