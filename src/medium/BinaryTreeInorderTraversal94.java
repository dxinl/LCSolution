package medium;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        traversal(root.left, result);
        result.add(root.val);
        traversal(root.right, result);
    }
}
