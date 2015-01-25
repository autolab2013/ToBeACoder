import java.util.Arrays;

/**
 * Created by yunong on 1/24/2015.
 */
public class MergeSort extends SortEssentials{
    static void mergesort(int[] array){
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length-1);
    }

    static void mergesort(int[] array, int[] helper, int low, int high){
        if(low < high){
            int middle = (low + high)/2;
            mergesort(array, helper, low, middle);
            mergesort(array, helper, middle+1, high);//be careful with middle+1
            merge(array, helper, low, middle, high);
        }
    }

    static void merge(int[] array, int[] helper, int low, int middle, int high){
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

    public static void tester(){
        int[] arr = createRandArr(10);
        System.out.println("original:");
        System.out.println(Arrays.toString(arr));
        mergesort(arr);
        System.out.println("merge sorted:");
        System.out.println(Arrays.toString(arr));
    }


}
