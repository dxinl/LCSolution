package medium;

import java.util.Arrays;

public class SearchForARange34 {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(new SearchForARange34().searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }

    private int mStart, mEnd;

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        mStart = 0;
        mEnd = nums.length;
        int mid = binarySearch(nums, 0, nums.length, target, true);
        if (mid == -1) {
            return new int[]{-1, -1};
        }

        int start = mid;
        int tmp;
        while ((tmp = binarySearch(nums, mStart, start, target, false)) != -1) {
            start = tmp;
        }

        int end = mid;
        while ((tmp = binarySearch(nums, end + 1, mEnd, target, false)) != -1) {
            end = tmp;
        }

        return new int[]{start, end};
    }

    private int binarySearch(int[] nums, int start, int end, int target, boolean firstTime) {
        while (start < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) {
                if (firstTime) {
                    mStart = start;
                    mEnd = end;
                }
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }

        return -1;
    }
}
