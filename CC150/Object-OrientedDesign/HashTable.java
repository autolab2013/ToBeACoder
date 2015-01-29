/** 8.10 Design and implement a hash table which uses chaining (linked lists) to handle collisions.
 *  
 */
 
/** I think
 *  HashTable has add(), get(), contains(), remove(), 
 *  now every object in HashTable is a linked list
 *  
 */
 
class HashTable{
	int capacity;
	ArrayList<Chain> list;
	
	get(Object){
		chain = list.get(hashcode(Object));
		return chain.get(chain.hashcode(object));
	}
	
	contains(object){
		if(get(object) == null)
			return false;
		return true;
	}
	
	hashcode(Object)
	
	add(object){
		chain = list.get(object);
		chain.add(hashcode(object), object);
	}
	
	remove(object){
		if(contains(object))
			chain = list.get(object);
			chani.remove(chain.hashcode(object));
	}
}