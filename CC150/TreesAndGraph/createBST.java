/**
 *  4.3 Given a sorted(increasing order) array with unique integer, write an algorithm
 *  to create a binary search tree with minimal height 
 */

class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int v){
		value = v;
		left = null;
		right = null;
	}
}
 
public Node getRoot(int[] arr){
	return createBST(arr, 0, arr.length-1);
}

private Node createBST(int[] arr, int start, int end){
	if(start > end) return null;
	int mid = start + (end - start)/2;
	Node root = new Node(arr[mid]);
	root.left = createBST(arr, start, mid-1);
	root.right = createBST(arr, mid+1, end);
	return root;
}