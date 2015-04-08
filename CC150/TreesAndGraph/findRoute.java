/**
 *  4.2 Given a directed graph, design an algorithm to find out whether there is a route
 *  between two nodes.
 */
 
class Node{
	ArrayList<Node> neighbor;
}

public boolean hasRoute(Node src, Node dest){
	//BFS
	if(src == dest) return true;
	ArrayList<Node> queue = new ArrayList<Node>();
	HashSet<Node> visited = new HashSet<Node>();
	queue.add(src);
	while(!queue.isEmpty()){
		Node curr = visited.remove(0);
		for(Node next : curr.neighbor){
			if(!visited.contains(next)){
				if(next == dest)
					return true;
				queue.add(next);
			}
		}visited.add(curr);
	}return false;
	
}