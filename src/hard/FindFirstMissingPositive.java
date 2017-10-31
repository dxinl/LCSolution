package hard;

public class FindFirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(new Solution().firstMissingPositive(nums));

        int[] nums2 = {3,4,-1,1};
        System.out.println(new Solution().firstMissingPositive(nums2));
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            int length = nums.length;
            int[] tmp = new int[length];
            for (int i = 0; i < length; ++i) {
                if (nums[i] > 0 && nums[i] <= length) {
                    tmp[nums[i] - 1] = nums[i];
                }
            }

            for (int i = 0; i < length; ++i) {
                if (tmp[i] == 0) {
                    return i + 1;
                }
            }

            return length + 1;
        }
    }
}
