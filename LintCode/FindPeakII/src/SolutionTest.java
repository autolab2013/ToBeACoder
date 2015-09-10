import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Riley on 9/7/2015.
 */
public class SolutionTest {

    @Test
    public void testFindPeakII() throws Exception {
//        [[1,2,3,4,5,6],[14,15,16,17,18,8],[12,13,11,10,9,7]]
        int[][] A = {{1, 2, 3, 4, 5, 6}, {14, 15, 16, 17, 18, 8}, {12, 13, 11, 10, 9, 7}};
        Solution s = new Solution();
        List<Integer> list = s.findPeakII(A);
        for(Integer item : list) {
            System.out.println(item);
        }
        System.out.println("test");
        return;
    }
}