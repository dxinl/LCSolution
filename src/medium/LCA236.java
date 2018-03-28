package medium;

import datastructure.TreeNode;

public class LCA236 {
    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, n7, n4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5, n6, n2);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n1 = new TreeNode(1, n0, n8);
        TreeNode n3 = new TreeNode(3, n5, n1);
        System.out.println(new LCA236().lowestCommonAncestor(n3, n3, n4));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if ((left != null && right != null)) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
