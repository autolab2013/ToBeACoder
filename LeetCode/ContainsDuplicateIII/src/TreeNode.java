/**
 * Created by YunongLiu on 9/26/2015.
 */
public class TreeNode {
    public int val;
    public int size;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int v) {
        val = v;
        size = 1;
        left = null;
        right = null;
        parent = null;
    }
}
