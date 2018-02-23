package easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers728 {
    public static void main(String[] args) {
        System.out.println(new SelfDividingNumbers728().selfDividingNumbers(1, 22));
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> results = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int d = 10;
            int s = i;
            boolean y = true;
            while (s > 0) {
                int tmp = s % d;
                if (tmp == 0) {
                    y = false;
                    break;
                }

                if (i % tmp != 0) {
                    y = false;
                    break;
                }

                s /= 10;
            }

            if (y) {
                results.add(i);
            }
        }
        return results;
    }
}
