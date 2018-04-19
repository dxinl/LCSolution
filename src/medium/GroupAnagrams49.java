package medium;

import java.util.*;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        }

        List<int[]> keys = new ArrayList<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            int found = -1;
            for (int i = 0, size = keys.size(); i < size; i++) {
                if (Arrays.equals(keys.get(i), count)) {
                    found = i;
                    break;
                }
            }

            if (found == -1) {
                List<String> anagrams = new LinkedList<>();
                anagrams.add(str);
                result.add(anagrams);
                keys.add(count);
            } else {
                List<String> anagrams = result.get(found);
                anagrams.add(str);
            }
        }
        return result;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        }

        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41,
                43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int count = 1;
            for (char c : str.toCharArray()) {
                count *= prime[c - 'a'];
            }

            List<String> anagrams = map.get(count);
            if (anagrams == null) {
                anagrams = new LinkedList<>();
                result.add(anagrams);
                map.put(count, anagrams);
            }
            anagrams.add(str);
        }

        return result;
    }
}
