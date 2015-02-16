/** 9.3 A magic index in an array A[0...n-1] is defined to be an index such that A[i]=i.
 *  Given a sorted array of distinct integers, write a method to find a magic index, if
 *  one exists, in array A.
 *  FOLLOW UP
 *  what if the values are not distinct.
 */

//binary search: left<= want <right;
public static int findMagicIndex(int[] arr, int start, int end){
	if(arr[0] > 0 || arr[arr.lenght-1] < arr.length-1)
		return -1;
	else{
		int middle = (start + end)/2;
		if(arr[middle] == middle)
			return middle;
		else{
			if(arr[middle] < middle)
				return findMagicIndex(arr, middle, arr.lenght-1);
			else
				return findMagicIndex(arr, start, middle);
		}
	}
}

//FOLLOW UP: if values are not distinct
public static findMagicIndex(int[] arr, int start, int end){
	if(start > end || start < 0 || end > arr.length-1 || arr[end] < 0 || arr[start] > end)
		return -1;
	else if(arr[start] > start)
		return findMagicIndex(arr, arr[start], end);
	else if(arr[end] < end)
		return findMagicIndex(arr, start, arr[end]);
	else{
		int mid = (start+end)/2;
		if(arr[mid] == mid)
			return mid;
		else{
			int index = findMagicIndex(arr, start, mid-1);
			if( index > -1)
				return index;
			else
				return findMagicIndex(arr, arr[mid], end);
		}
	}
}