package easy;

public class MissingNumber268 {
    public static void main(String[] args) {
        System.out.println(new MissingNumber268().missingNumber(new int[]{1}));
    }

    public int missingNumber(int[] nums) {
        for (int n : nums) {
            n = (n > nums.length || n < 0) ? (n - nums.length - 1) : n;
            if (n < nums.length) {
                nums[n] += nums.length + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] <= nums.length) {
                return i;
            }
        }
        return nums.length;
    }

    public int bestAnswer(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }
}
