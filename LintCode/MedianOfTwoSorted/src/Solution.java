/**
 * Created by YunongLiu on 9/13/2015.
 */
class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int size = A.length + B.length;
        if(size % 2 == 1) return quickSelect(A, 0, B, 0, size/2);
        else return (quickSelect(A, 0, B, 0, (size-1)/2) + quickSelect(A, 0, B, 0, size/2))/2.0;
    }

    // select median of A : if mA is also median of B => B[n/2-1] < mA < B[n/2] return
    // if mA < B[n/2-1] : need incr mA
    // if mA > B[n/2] : need decr mA
    private int quickSelect(int[] A, int s1, int[] B, int s2, int k) {
        if(s1 >= A.length) return B[s2+k];
        if(s2 >= B.length) return A[s1+k];
        if(k == 0) return Math.min(A[s1], B[s2]);
        if(k == 1) return Math.max(A[s1], B[s2]);
        int med_A = A[s1 + k/2];
        int med_B = B[s2 + k/2];
        if(med_A == med_B) return med_A;
        else if(med_A > med_B) return quickSelect(A, s1, B, s2+k/2,  k-k/2);
        else return quickSelect(A, s1+k/2, B, s2, k-k/2);
    }
}


