/** 11.3 Given a sorted array of n integers that has been rotated an unknown number of times, 
 *  write code to find an element in the array. You may assume that the array was originally
 *  sorted in increasing order. 
 *  E.g.
 *  Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 *  Output: 8(the index of 5 in the array)
 */
 
//9:31

/** I think
 *  binary search 
 *  how to ?
 *  arr = [left-start left-end right-start right-end]
 *  if left-start < left-end and left-start < element < left-end, do binary in left
 *  else in right
 *  if start < end: a in-order segment
 *  	then if start < element < end, binary
 *  else start > end: start- start_end , end_start - end
 *  	
 *  	if middle = (start + end)/2 > start, then start - middle in order, start-end > middle
 *  	else end_start > middle
 */
 
/** Book solution
 *  I think there is something to be clarified: what is actually an array rotation?
 *  According to this: http://leetcode.com/2010/04/searching-element-in-rotated-array.html
 *  a rotated array is rotated at some pivot, so it is like swap segment on the left and right side
 *  of the pivot
 *  Under this assumption, I can guaranteed that if left < right then this segment must be in order
 */
 
public static int find(int[] array, int element){
	int left = 0;
	int right = array.length;
	int middle = (left + right)/2;
	if(array[left] < array[middle])// in order segment
		return binary_search(array, left, middle, element);
	else if (array[left] == array[middle])
	else// right part is in order
		return binary_search(array, middle, right, elemnt);
}
private static int binary_search(int[] array, int left, int right, int element){
	int middle = (left+right)/2;
	if(array[middle] == element)
		return middle;
	if(array[middle] > element)
		return binary_search(array, left, middle, element);
	else 
		return binary_search(array, left, middle, element);
	return -1;
}