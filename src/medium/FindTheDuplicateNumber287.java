package medium;

public class FindTheDuplicateNumber287 {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 2) {
            return nums[0];
        }

        int slow = nums[0];
        int fast = nums[slow];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int slow2 = nums[0];
        while (slow2 != slow) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow2;
    }
}
