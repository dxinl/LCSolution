package medium;

import datastructure.TreeNode;

import java.util.LinkedList;

public class KthSmallestInBST230 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n5.left = n3;
        n5.right = n7;

        n3.left = n2;
        n3.right = n4;
        n2.left = n1;

        n7.left = n6;
        n7.right = n8;

        new KthSmallestInBST230().kthSmallest(n5, 6);
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        LinkedList<TreeNode> nodes = new LinkedList<>();
        while (!nodes.isEmpty() || root != null) {
            if (root != null) {
                nodes.offerLast(root);
                root = root.left;
            } else {
                k--;
                root = nodes.pollLast();
                if (k == 0) {
                    return root.val;
                }

                root = root.right;
            }
        }

        return -1;
    }
}
