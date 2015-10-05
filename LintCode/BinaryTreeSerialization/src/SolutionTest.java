import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YunongLiu on 9/27/2015.
 */
public class SolutionTest {

    @Test
    public void testSerialize() throws Exception {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        Solution test = new Solution();
        String data = test.serialize(root);
        data = "3,9,20,#,#,15,7";
        TreeNode droot = test.deserialize(data);
        return ;
    }

    @Test
    public void testDeserialize() throws Exception {

    }
}