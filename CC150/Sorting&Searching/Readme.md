Chap 11
===

Common Sorting alg:

 	name | runtime Average/Worst | Memory
	---- | ------------------ | ------
	Bubble sort | O(n^2) | O(1)
	Selection Sort | O(n^2) | O(1)
	Merge sort | O(n*log(n)) | depends
	Quick sort | O(n*log(n))/ O(n^2) | O(log(n))
	Radix sort | O(kn) k is the number of passes of alg|

Searching alg:
- binary search

Merge sort code:
```java
void mergesort(int[] array){
	int[] helper = new int[array.length];
	mergesort(array, helper, 0, array.length-1);
}

void mergesort(int[] array, int[] helper, int low, int high){
	if(low < high){
		int middle = (low + high)/2;
		mergesort(array, helper, low, middle);
		mergesort(array, helper, middle+1, high);//be careful with middle+1
		merge(array, helper, low, middle, high);
	}
}

void merge(int[] array, int[] helper, int low, int middle, int high){
	//copy array to helper
	for(int i=0;i < array.length; i++){
		helper[i] = array[i];
	}
	int helper_left = low;
	int helper_right = middle+1;
	int curr = low;
	
	while(helper_left <= middle && helper_right <= high){
		if(helper[helper_left] < helper[helper_right]){
			array[curr] = helper[helper_left];
			helper_left++;
		}else{
			array[curr] = helper[helper_right];
			helper_right++;
		}
		curr++;
	}
	//copy remaining left side of the array into target
	int remaining = middle - helper_left;
	for(int i=0; i<= remaining; i++){
		array[curr+i] = helper[helper_left+i]; 
	}
}
```

Quick sort code:
```
```