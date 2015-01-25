/** 11.1 you are give two sorted arrays, A and B, where A has a large enough buffer at the end
 *  to hold B. Write a method to merge B into A in sorted order.
 */
 
//7:08PM

/** I think
 *  merge sort A and B, iterator i for A, j for B
 *  if A[i] > B[j], swap A[i] and B[j]
 *  copy B to the end of A
 */
 
int[] mergeSortA&B(int[] A, int[] B, int len){
	int i;
	for( i=0; i<len; i++){
		if(A[i] > B[0])
			break;
	}
	int left = len - i;
	int[] c = new int[left];
	for(int j=i, int k=0;j<len;j++, k++){
		c[k] = A[j]; 
	}
	int remaining = i;
	for(int j = remaining; j< B.length; j++, i++){
		A[i] = B[j];
	}
	for(int j = i, int k=0; j<left; j++, k++){
		A[j] = c[k]
	}
	
	return A;
}

//7:30pm

/** Book solution
 *  use A to save space
 *  if compare A and B from start, when insert B into A need to shift A
 *  if compare A and B from end, don't need additional space to shift
 */

public int[] mergeSortA&B(int[] A, int[] B, int lastA, int lastB){
	int merged_last = lastA + lastB-1;
	int A_last = lastA-1;
	int B_last = lastB-1;
	
	while(B_last >= 0){
		if(A[A_last] > B_last)
			A[merged_last--] = A[A_last--];
		else
			A[merged_last--] = B[B_last--];

	}
	return A;
}