package easy;

import java.util.Arrays;

public class ArrayPartitionI561 {
    public static void main(String[] args) {
        System.out.println(new ArrayPartitionI561().arrayPairSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
