package easy;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevels637 {
    /**
     * Definition for a binary tree node.
     **/
    static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> current = new ArrayList<>();
        List<TreeNode> child = new ArrayList<>();
        List<Double> result = new ArrayList<>();

        current.add(root);
        int size = 1;
        while (size > 0) {
            double sum = 0;
            for (TreeNode node : current) {
                sum+=node.val;
                if (node.left != null) {
                    child.add(node.left);
                }
                if (node.right != null) {
                    child.add(node.right);
                }
            }
            result.add(sum / size);
            size = child.size();
            List<TreeNode> tmp = child;
            child = current;
            current = tmp;
            child.clear();
        }

        return result;
    }
}
