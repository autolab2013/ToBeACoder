/** 9.4 Write a method to return all subsets of a set.
 *  
 */
 
//4:03PM

/** I think
 *  combine every 1/2/3 elements together
 *  the total number of subsets of n elements is 2^n;
 *  I can remove from the whole set or add with 1 element each
 */
 
// public HashSet<Object> getSubset(HashSet<Object> set){
	// HashSet<HashSet<Object>> subsets = new HashSet<HashSet<Object>>();
	for(int elem = 0; elem < set.size(); elem++){//how many elements the subset takes
		for(int i=0; i<elem; i++){
			sub.add();
		}
	}
	// for(int elem=0; elem <= set.size(); elem++){
		// subsets.add(getSubset(set, elem));
	// }
	// return subsets;
// }

// private HashSet<Object> getSubset(HashSet<Object> set, HashSet<Object> element, int elem){
	// if(element.size() == elem)
		// return element;
	// for(Object ob: set){
		// element.add(ob)
	// }
	// return 
// }

public generateSubsetList(int size){
	ArrayList<ArrayList<boolean[]>> subset_list = new ArrayList<ArrayList<boolean[]>>();
	boolean[] list = new boolean[size];
	for(int i=0; i<size; i++){
		subset_list.add(generateSubsetList(list, i));
	}
}

private ArrayList<boolean[]> generateSubsetList(boolean[] list, int elem, int cnt, int index){
	if(cnt == elem)
		return list;
	for(int i=index; i<list.length; i++){
		list[i] = true;
		generateSubsetList(list, elem, cnt++, i);
	}
}