package medium;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence300().lengthOfLIS(new int[]{1,9,7,8,2,3,4}));
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 1) {
            return nums.length;
        }

        int[] length = new int[nums.length];
        int max = 1;
        length[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            length[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                int len;
                if (nums[i] > nums[j] && length[i] < (len = length[j] + 1)) {
                    length[i] = len;
                    if (max < len) {
                        max = len;
                    }
                }
            }
        }
        return max;
    }
}