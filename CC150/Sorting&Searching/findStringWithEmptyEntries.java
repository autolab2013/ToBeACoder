/**
 *  11.5 Given a sorted array of strings which is interspersed with empty strings, write a
 *  method to find the location of a given string. 
 */

public int findString(String[] arr, String pattern){
	return findString(arr, 0, arr.length, pattern);
}

private int findString(String[] arr, int left, int right, String pattern){
	if(left > right) return -1;
	int mid = (left+right)/2;
	if(arr[mid].equals(pattern)) return mid;
	if(arr[mid].isEmpty()){
		int ptr = mid;
		while(ptr >= left){
			if(arr[ptr].isEmpty()) ptr--;
			else break;
		}
		if(ptr < left){//not found in left
			ptr = mid;
			while(ptr <= right){
				if(arr[ptr].isEmpty) ptr++;
				else break;
			}
			if(ptr > right) return -1;
		}mid = ptr;
	}
	if(arr[mid].compareTo(pattern) > 0) return findString(arr, left, mid-1);
	else return findString(arr, mid+1, right);
}