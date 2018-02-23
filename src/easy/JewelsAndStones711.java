package easy;

import java.util.HashMap;

public class JewelsAndStones711 {
    public static void main(String[] args) {
        System.out.println(new JewelsAndStones711().numJewelsInStones("aA", "aAAbbbb"));
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
}
