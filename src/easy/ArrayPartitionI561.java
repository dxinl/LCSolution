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

    public int arrayPairSum2(int[] nums) {
        int[] array = new int[20001];
        for(int i=0;i<nums.length;i++){
            array[nums[i]+10000]++;
        }
        int sum = 0;
        boolean odd = true;
        for(int i=0;i<array.length;i++){
            while(array[i]>0){
                if(odd){
                    sum+=i-10000;
                }

                odd = !odd;
                array[i]--;
            }
        }
        return sum;
    }
}
