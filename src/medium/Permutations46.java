package medium;

import java.util.*;

public class Permutations46 {
    public static void main(String[] args) {
        System.out.println(new Permutations46().permute2(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }

        List<Integer> first = new ArrayList<>(nums.length);
        for (int num : nums) {
            first.add(num);
        }
        result.add(first);
        if (nums.length == 1) {
            return result;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int length = result.size();
            for (int j = 0; j < length; j++) {
                List<Integer> f = result.get(j);
                int c = 0;
                for (int k = i; k < nums.length - 1; k++) {
                    List<Integer> t = new ArrayList<>(nums.length);
                    for (int l = 0; l < i; l++) {
                        t.add(f.get(l));
                    }
                    int swapIndex = nums.length - 1 - c;
                    c++;
                    t.add(f.get(swapIndex));
                    for (int l = i; l < nums.length; l++) {
                        if (l != swapIndex)
                            t.add(f.get(l));
                    }
                    result.add(t);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }

        permute(nums, 0, result);
        return result;
    }

    private void permute(int nums[], int start, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            List<Integer> tmp = new ArrayList<>(nums.length);
            for (int num : nums) {
                tmp.add(num);
            }
            result.add(tmp);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permute(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b) {
            return;
        }
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
