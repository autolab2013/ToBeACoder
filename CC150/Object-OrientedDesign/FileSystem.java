/** 8.9 Explain the data structure and alg that you would use to design a 
 *  in-memory file system. Illustrate with an example in code where possible.
 */
 
/** I think:
 *  it is like a big linked list, the node can be a file or a directory
 *  file{
 *  	name;
 *  	content;
 *  	type;
 *  	timestamp;
 *  	size;
 *  
 *  	create();
 *  	delete();
 *  }
 *  directory{
 *  	name;
 *  	LinkedList content;
 *  	timestamp;
 *  	
 *  	create();
 *  	delete();
 *  } 
 */