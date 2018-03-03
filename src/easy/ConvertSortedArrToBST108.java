package easy;

public class ConvertSortedArrToBST108 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(null, nums, 0, nums.length, false);
    }

    private TreeNode convert(TreeNode root, int[] nums, int start, int end, boolean left) {
        if (end - start < 0) {
            return null;
        }

        int n = (start + end) >> 1;
        TreeNode tmp = new TreeNode(nums[n]);
        if (root != null) {
            if (left) {
                root.left = tmp;
            } else {
                root.right = tmp;
            }
        }

        root = tmp;
        if (n > start) {
            convert(root, nums, start, n, true);
        }
        if (n < end - 1) {
            convert(root, nums, n + 1, end, false);
        }
        return root;
    }
}
