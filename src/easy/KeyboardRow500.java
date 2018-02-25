package easy;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow500 {
    public String[] findWords(String[] words) {
        int length;
        if (words == null || (length = words.length) == 0) {
            return words;
        }

        int[] keyboard = new int[26];
        String[] keyboardRows = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        for (int i = 0, len = keyboardRows.length; i < len; i++) {
            for (int j = 0, rowLen = keyboardRows[i].length(); j < rowLen; j++) {
                keyboard[keyboardRows[i].charAt(j) - 'a'] = i;
            }
        }

        List<String> alphabet = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            String s = words[i];
            int sLen = s.length();
            if (sLen == 0) {
                alphabet.add(s);
                continue;
            }

            int row = getRow(keyboard, s.charAt(0));
            boolean flag = true;
            for (int j = 1; j < sLen; j++) {
                int row1 = getRow(keyboard, s.charAt(j));
                if (row != row1) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                alphabet.add(s);
            }
        }

        return alphabet.toArray(new String[alphabet.size()]);
    }

    private int getRow(int[] keyboard, char c) {
        if (c >= 'a' && c <= 'z') {
            return keyboard[c - 'a'];
        }

        if (c >= 'A' && c <= 'Z') {
            return keyboard[c - 'A'];
        }
        return 0;
    }
}
