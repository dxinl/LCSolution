package medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateInArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new Solution().findDuplicates(nums));
    }

    static class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0, len = nums.length; i < len; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] < 0) {
                    result.add(index + 1);
                }
                nums[index] = -nums[index];
            }

            return result;
        }
    }
}
