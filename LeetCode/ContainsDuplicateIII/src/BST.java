/**
 * Created by YunongLiu on 9/26/2015.
 */
public class BST {
    private TreeNode root;

    public BST() { root = null; }

    public int size() {
        if(root == null) return 0;
        return root.size;
    }

    public void add(int v) {
        root = add(root, v);
    }

    private TreeNode add(TreeNode root, int v) {
        if(root == null) return new TreeNode(v);
        else {
            if(v > root.val) {
                root.right = add(root.right, v);
                root.right.parent = root;
            }else {
                root.left = add(root.left, v);
                root.left.parent = root;
            }
            root.size += 1;
            return root;
        }
    }

    public void remove(int v) {
        TreeNode stale = find(root, v);
        if(stale == null) return ;
        TreeNode next = null;
        if(stale.left != null) {
            next = stale.left;
            while(next.right != null) {
                next = next.right;
            }
            if(next.parent != null) {
                TreeNode parent = next.parent;
                if(next == parent.left) parent.left = next.left;
                else parent.right = next.left;
                if(next.left != null) next.left.parent = parent;
                parent.size = 0;
                if(parent.left != null) parent.size += parent.left.size;
                if(parent.right != null) parent.size += parent.right.size;
            }
        } else if(stale.right != null) {
            next = stale.right;
            while(next.left != null) {
                next = next.left;
            }
            if(next.parent != null) {
                TreeNode parent = next.parent;
                if(next == parent.left) parent.left = next.right;
                else parent.right = next.right;
                if(next.right != null) next.right.parent = parent;
                parent.size = 0;
                if(parent.left != null) parent.size += parent.left.size;
                if(parent.right != null) parent.size += parent.right.size;
            }
        }
        if(next != null) {
            next.parent = stale.parent;
            next.left = stale.left;
            next.right = stale.right;
            next.size = 0;
            if(next.left != null) next.size += next.left.size;
            if(next.right != null) next.size += next.right.size;
        }
        root = next;
    }

    private TreeNode remove(TreeNode root, int v) {
        if(root == null) return null;
        else {
            if(root.val == v) {
                TreeNode next = null;
                if(root.left != null) {
                    next = root.left;
                    while(next.right != null) {
                        next = next.right;
                    }
                    if(next.parent != null) {
                        TreeNode parent = next.parent;
                        if(next == parent.left) parent.left = next.left;
                        else parent.right = next.left;
                        if(next.left != null) next.left.parent = parent;
                    }
                } else if(root.right != null) {
                    next = root.right;
                    while(next.left != null) {
                        next = next.left;
                    }
                    if(next.parent != null) {
                        TreeNode parent = next.parent;
                        if(next == parent.left) parent.left = next.right;
                        else parent.right = next.right;
                        if(next.right != null) next.right.parent = parent;
                    }
                }
                if(next != null) {
                    next.parent = root.parent;
                    next.left = root.left;
                    next.right = root.right;
                }
                return next;
            } else if(root.val > v) root.right = remove(root.right, v);
            else root.left = remove(root.left, v);
            return root;
        }
    }

    public TreeNode find(int v) {
        return find(root, v);
    }

    private TreeNode find(TreeNode root, int v) {
        if(root == null) return null;
        if(root.val == v) return root;
        else if(root.val < v) return find(root.left, v);
        else return find(root.right, v);
    }
}
