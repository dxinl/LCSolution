package easy;

import datastructure.TreeNode;

public class MaxDepthOfBT104 {
    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }

    private int depth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        depth++;
        return Math.max(depth(root.left, depth), depth(root.right, depth));
    }
}
