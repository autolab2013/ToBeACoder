import java.util.ArrayList;

/**
 * Created by YunongLiu on 9/26/2015.
 */
public class Solution {

    public static void main(String[] args) {

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        BST tree = new BST();
        for(int i=0; i<nums.length; i++) {
            int curr = nums[i];
            tree.add(curr);
            if(tree.size() > k+1) tree.remove(nums[i-k-1]);
            TreeNode node = tree.find(curr);
            if(isNear(node, curr, t)) return true;
        }
        return false;
    }

    private boolean isNear(TreeNode root, int num, int t) {
        if(root == null) return false;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root.parent);
        list.add(root.left);
        list.add(root.right);
        for(TreeNode n : list) {
            if(n != null && Math.abs(n.val - num) <= t) return true;
        }
        return false;
    }
}
