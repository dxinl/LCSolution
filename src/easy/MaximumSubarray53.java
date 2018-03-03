package easy;

public class MaximumSubarray53 {
    public static void main(String[] args) {
        System.out.println(new MaximumSubarray53().maxSubArray(new int[]{-2, 1}));
        System.out.println(new MaximumSubarray53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] sum = new int[nums.length];
        System.arraycopy(nums, 0, sum, 0, nums.length);
        int max = sum[0];
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            sum[start] += nums[i];
            if (sum[start] > max) {
                max = sum[start];
            }
            if (nums[i] > max) {
                start = i;
                max = nums[i];
            } else if (nums[i] > sum[start]) {
                start = i;
            }
        }

        return max;
    }
}
