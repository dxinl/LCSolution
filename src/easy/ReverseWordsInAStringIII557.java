package easy;

import java.util.Arrays;

public class ReverseWordsInAStringIII557 {
    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAStringIII557().reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }

        int start = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        reverse(chars, start, length - 1);

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
