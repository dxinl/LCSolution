package medium;

import java.util.Arrays;

public class KthLargestElementInArray215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
