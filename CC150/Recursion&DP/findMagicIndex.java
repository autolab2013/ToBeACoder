/** 9.3 A magic index in an array A[0...n-1] is defined to be an index such that A[i]=i.
 *  Given a sorted array of distinct integers, write a method to find a magic index, if
 *  one exists, in array A.
 *  FOLLOW UP
 *  what if the values are distinct.
 */

//binary search: left<= want <right;
public static int findMagicIndex(int[] arr, int start, int end, int magic){
	if(arr[0] > 0 || arr[arr.lenght-1] < arr.length-1)
		return -1;
	else{
		int middle = (start + end)/2;
		if(arr[middle] == middle)
			return middle;
		else{
			if(arr[middle] < middle)
				return findMagicIndex(arr, middle, arr.lenght-1, magic);
			else
				return findMagicIndex(arr, start, middle, magic);
		}
	}
}