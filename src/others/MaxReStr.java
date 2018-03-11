package others;

public class MaxReStr {
    public String findStr(String s) {
        if (s == null) {
            return null;
        }
        //最长重复子串的长度
        int max = 0;
        //最长重复子串的第一个字符在s中的下标
        int first = 0;
        String res = null;
        //i为每次循环设定的字符串比较间隔：1,2，...，s.length()-1
        for (int i = 1; i < s.length(); i++) {
            for (int k = 0, j = 0; j < i && k + i < s.length(); j++) {
                if (s.charAt(j) == s.charAt(k + i))
                    k++;
                else
                    k = 0;
                if (k > max) {
                    max = k;
                    first = j - max + 1;
                }
            }
            if (max > 0) {
                res = s.substring(first, first + max);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "qqqqqqqqqq";
        System.out.println(new MaxReStr().findStr(s));
    }
}
