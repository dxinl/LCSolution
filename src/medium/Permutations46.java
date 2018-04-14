package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations46 {
    public static void main(String[] args) {
        System.out.println(new Permutations46().permute(new int[]{1, 2, 3}));
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
}
