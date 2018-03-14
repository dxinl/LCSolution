package easy;

import java.util.HashMap;

public class JewelsAndStones771 {
    public static void main(String[] args) {
        System.out.println(new JewelsAndStones771().numJewelsInStones2("z", "ZZ"));
    }

    public int numJewelsInStones(String J, String S) {
        HashMap<Character, String> jewels = new HashMap<>();
        int length = J.length();
        if (length == 0) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            jewels.put(J.charAt(i), J);
        }

        int count = 0;
        length = S.length();
        for (int i = 0; i < length; i++) {
            if (jewels.get(S.charAt(i)) != null) {
                count++;
            }
        }

        return count;
    }

    public int numJewelsInStones2(String J, String S) {
        int[] chars = new int[52];
        int length = J.length();
        for (int i = 0; i < length; i++) {
            char c = J.charAt(i);
            if (c <= 'Z' && c >= 'A') {
                chars[c - 'A' + 26]++;
            } else {
                chars[c - 'a']++;
            }
        }

        int count = 0;
        for (int i = 0, len = S.length(); i < len; i++) {
            char c = S.charAt(i);
            if (c <= 'Z' && c >= 'A' && chars[c - 'A' + 26] > 0) {
                count++;
            } else if (c <= 'z' && c >= 'a' && chars[c - 'a'] > 0) {
                count++;
            }
        }
        return count;
    }
}
