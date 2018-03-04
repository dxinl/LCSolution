package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements347 {
    public static void main(String[] args) {
        System.out.println(new TopKFrequentElements347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        System.out.println(new TopKFrequentElements347().topKFrequent(new int[]{1,1,1,1,1,1,1,1}, 1));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> times = new HashMap<>();
        for (int num : nums) {
            times.merge(num, 1, (a, b) -> a + b);
        }

        List<Integer>[] counts = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : times.entrySet()) {
            Integer value = entry.getValue();
            if (counts[value] == null) {
                counts[value] = new ArrayList<>();
            }
            counts[value].add(entry.getKey());
        }

        List<Integer> r = new ArrayList<>();
        for (int i = counts.length - 1, c = 0; r.size() < k && i >= 0; i--) {
            if (counts[i] != null) {
                r.addAll(counts[i]);
            }
        }

        return r;
    }
}
