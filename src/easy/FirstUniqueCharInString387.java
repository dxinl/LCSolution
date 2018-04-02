package easy;

public class FirstUniqueCharInString387 {
    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharInString387().firstUniqChar("leetcode"));
    }

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            ++count[index];
        }

        for (int i = 0; i < len; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
