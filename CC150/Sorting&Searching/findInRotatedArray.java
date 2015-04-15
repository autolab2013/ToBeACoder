/** 11.3 Given a sorted array of n integers that has been rotated an unknown number of times, 
 *  write code to find an element in the array. You may assume that the array was originally
 *  sorted in increasing order. 
 *  E.g.
 *  Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 *  Output: 8(the index of 5 in the array)
 */

public int findInRotatedArray(int[] arr, int element){
	return findInRotatedArray(arr, 0, arr.length, element);
} 

// this assumes no identical elements in arr
private int findInRotatedArray(int[] arr, int left, int right, int element){
	int index = -1;
	int left = 0;
	int right = arr.length;
	while(left <= right){
		int mid = (left + right)/2;
		if(mid == element) return mid;
		if(arr[left] < arr[mid]){//[left, mid] in order
			if(arr[left] <= element && arr[mid] >= element) return findInRotatedArray(arr, left, mid-1, element);
			return findInRotatedArray(arr, mid+1, right, element);
		}else if(arr[left] > arr[mid]){//[mid, right] in order
			if(arr[mid] <= element && arr[right] >= element) return findInRotatedArray(arr, mid+1, right, element);
			return findInRotatedArray(arr, left, mid-1, element);
		}else if(arr[left] == arr[mid]){//consideration for identical elment
			if(arr[right] != arr[mid]){
				return findInRotatedArray(arr, mid+1, right, element);
			}else{
				index = findInRotatedArray(arr, left, mid-1, element);
				if(index != -1) return index;
				return findInRotatedArray(arr, mid+1, right, element);
			}
		}
	}
	return index;
}