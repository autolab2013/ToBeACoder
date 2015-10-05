/**
 * Created by YunongLiu on 9/27/2015.
 */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    private String ser_tree = "";

    public String serialize(TreeNode root) {
        // write your code here
        preorder(root);
        return ser_tree;
    }

    private void preorder(TreeNode root) {
        if(root == null) {
            if(ser_tree.isEmpty()) ser_tree += "#";
            else ser_tree += ",#";
        } else {
            if(ser_tree.isEmpty()) ser_tree += root.val;
            else ser_tree += "," + root.val;
            preorder(root.left);
            preorder(root.right);
        }
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        return construct(null);
    }

    private TreeNode construct(TreeNode root) {
        if(ser_tree.isEmpty()) return null;
        String val = "";
        int ptr = 0;
        while(ptr < ser_tree.length()) {
            if(Character.isDigit(ser_tree.charAt(ptr))) {
                val += ser_tree.charAt(ptr);
                ptr++;
            } else break;
        }
        if(!val.isEmpty()) {
            root = new TreeNode(Integer.parseInt(val));
            ser_tree = ser_tree.substring(ptr+1);
            root.left = construct(root.left);
            root.right = construct(root.right);
        } else {
            if(ser_tree.equals("#")) ser_tree = "";
            else ser_tree = ser_tree.substring(2);
        }
        return root;
    }
}


