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
	// helper = [ 4 5 6 || 1 2 3], if left always < right, then after for() loop have to copy left part to array
	// if right > left, they are already in position when we got array
	int remaining = middle - helper_left;
	for(int i=0; i<= remaining; i++){
		array[curr+i] = helper[helper_left+i]; 
	}
}
```

Quick sort code:
```java
void quickSort(int[] arr, int left, int right){
	int index = partition(arr, left, right);
	if(left < index - 1)
		quickSort(arr, left, index - 1);
	if(index < right)
		quickSort(arr, index, right);
}

int partition(int arr[], int left, int right){
	int pivot = arr[(left+right)/2];
	while(left <= right){
		while(arr[left] <pivot){
			left++;
		}while(arr[right] > pivot){
			right--;
		}
		if(left <= right){
			swap(arr, left, right);
			left++;
			right--;
		}
		
	}
	return left;
}
```