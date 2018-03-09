package medium;

public class FindPeakElement162 {
    public static void main(String[] args) {
        System.out.println(new FindPeakElement162().findPeakElement(new int[]{5,2,3,4}));
    }
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] < nums[mid]) {
                    return mid;
                } else {
                    end = mid;
                }
            }
        }
        return -1;
    }
}
