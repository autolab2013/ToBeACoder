import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YunongLiu on 9/26/2015.
 */
public class SolutionTest {

    @Test
    public void testContainsNearbyAlmostDuplicate() throws Exception {
        Solution test = new Solution();
        int[] nums = {3,6,0,4}; //{2, 1};
        int k = 2;
        int t = 2;
        test.containsNearbyAlmostDuplicate(nums, k, t);
    }
}