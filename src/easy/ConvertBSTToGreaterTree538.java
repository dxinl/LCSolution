package easy;

public class ConvertBSTToGreaterTree538 {
    /**
     * Definition for a binary tree node.
     **/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        // [2,0,3,-4,1]
        TreeNode root = new TreeNode(2);
        TreeNode n0 = new TreeNode(0);
        TreeNode n3 = new TreeNode(3);
        TreeNode n_4 = new TreeNode(-4);
        TreeNode n1 = new TreeNode(1);
        root.left = n0;
        root.right = n3;
        n0.left = n_4;
        n0.right = n1;
        new ConvertBSTToGreaterTree538().convertBST(root);
    }

    public TreeNode convertBST(TreeNode root) {
        getChildVal(root, 0);
        return root;
    }

    private int getChildVal(TreeNode root, int parentVal) {
        if (root == null) {
            return 0;
        }

        root.val += getChildVal(root.right, parentVal) + parentVal;
        if (root.left != null) {
            return getChildVal(root.left, root.val);
        }
        return root.val;
    }
}
