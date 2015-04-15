/** Write a method to sort an array of Strings so that all the anagrams are next to each other.
 *  
 */
 
//8:46pm

/** I think 
 *  use the sum of characters as hash function.
 *  different string with same sum? 
 *  try check length 
 *  shorter length at the front
 */
 
String[] sortStringArray(String[] array){
	HashMap<HashSet<Character>, String> map = new HashMap<>();
	for(String s : array){
		HashSet<Character> charset = getSet(s);
		map.put(charset, s);
	}
	String arr = map.keySet.toArray();
	quicksort(arr, 0, arr.length-1);
}

private HashSet<Character> getSet(String s){
	HashSet<Character> set = new HashSet<>();
	for(int i=0;i<s.length();i++){
		set.add(s.charAt(i));
	}return set;
}

private void quicksort(String[] arr, int left, int right){
	int pivot = partition(arr, left, right);
	if(left < pivot){
		quicksort(arr, start, pivot-1);
	if(pivot < right)
		quicksort(arr, pivot+1, end);
}

private int partition(String[] arr, int left, int right){
	String pivot = arr[left + (right - left)/2];
	while(left <= right){
		while(arr[left].comparTo(pivot) < 0)
			left++;
		while(arr[right].comparTo(pivot) > 0)
			right--;
		if(left <= right){
			swap(arr, left, right);
			left++;
			right--;
		}
	}return left;
}


/** Book solution
 *  use hash map to map anagrams to the same character sets
 */

// I use Character HashSet and ArrayList<String>, book uses sorted characters as key and LinkedList<String> 
static String[] sortStringArray(String[] array){
    HashMap<HashSet<Character>, ArrayList<String>> map = new HashMap<HashSet<Character>, ArrayList<String>>();
    for(String s: array){
        char[] char_arr = s.toCharArray();
        HashSet<Character> char_set = new HashSet<Character>();
        for(Character c: char_arr){
            char_set.add(c);
        }
        if(!map.keySet().contains(char_set)){
            ArrayList<String> str_list = new ArrayList<String>();
            map.put(char_set, str_list);
        }
        map.get(char_set).add(s);
    }
    int j =0;
    for(HashSet<Character> set: map.keySet()){
        for(String str: map.get(set)){
            array[j] = str;
            j++;
        }
    }
    return array;
}

//9:30PM