package medium;

import java.util.HashMap;
import java.util.Map;

public class FourSumII454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                map.merge(a + b, 1, (old, val) -> old + val);
            }
        }

        int result = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = -(c + d);
                result += map.getOrDefault(sum, 0);
            }
        }

        return result;
    }
}
