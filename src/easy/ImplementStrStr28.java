package easy;

public class ImplementStrStr28 {
    public static void main(String[] args) {
//        System.out.println(new ImplementStrStr28().strStr("Hello", "ll"));
        System.out.println(new ImplementStrStr28().strStr("mississippi", "issip"));
        System.out.println(new ImplementStrStr28().strStr("aaaaaaa", "bba"));
        System.out.println(new ImplementStrStr28().strStr("a", "a"));
    }

    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 < len2) {
            return -1;
        } else if (len2 == 0) {
            return 0;
        }

        for (int i = 0; i <= len1 - len2;) {
            while (haystack.charAt(i) != needle.charAt(0)) {
                i++;
                if (i > len1 - len2 + 1) {
                    return -1;
                }
            }

            int j = i + 1;
            int k = 1;
            if (k == len2) {
                return i;
            }

            while (j < len1 && haystack.charAt(j) == needle.charAt(k)) {
                j++;
                k++;
                if (k == len2) {
                    return i;
                }

                if (j > len1) {
                    return -1;
                }
            }
            i++;
        }

        return -1;
    }
}
