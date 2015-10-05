import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YunongLiu on 9/13/2015.
 */
public class SolutionTest {

    @Test
    public void testFindMedianSortedArrays() throws Exception {
//        [5,6,9,10], [0,2,3,4]
        int[] A = {5, 6, 9, 10};
        int[] B = {0, 2, 3, 4};
        Solution solu = new Solution();
        solu.findMedianSortedArrays(A, B);
    }
}