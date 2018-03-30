package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        List<char[]> result = new ArrayList<>();
        if (n == 0) {
            return new ArrayList<>();
        }

        int length = n << 1;
        char[] c = new char[length];
        c[0] = '(';
        c[1] = 1;
        result.add(c);
        for (int i = 1; i < length - 1; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                c = result.get(j);
                if (c[i] > 0 && c[i] + i + 1 < length) {
                    char[] c2 = Arrays.copyOf(c, length);
                    c2[i] = ')';
                    c2[i + 1] = (char) (c[i] - 1);
                    result.add(c2);
                    c[i + 1] = (char) (c[i] + 1);
                    c[i] = '(';
                } else if (c[i] > 0) {
                    c[i + 1] = (char) (c[i] + 1);
                    c[i] = ')';
                } else {
                    c[i + 1] = (char) (c[i] + 1);
                    c[i] = '(';
                }
            }
        }

        return getStrs(result, length);
    }

    private List<String> getStrs(List<char[]> css, int length) {
        List<String> result = new LinkedList<>();
        for (char[] cs : css) {
            cs[length - 1] = ')';
            result.add(new String(cs));
        }

        return result;
    }
}
