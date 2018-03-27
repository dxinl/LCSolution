package easy;

public class ReverseBits190 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(new ReverseBits190().reverseBits(1)));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int mask = 1;
        int c = 0;
        int[] r = new int[32];
        while (c < 32) {
            r[c] = ((n & mask) == 0 ? 0 : 1);
            mask <<= 1;
            c++;
        }

        int result = 0;
        for (int i = 1; i < 32; i++) {
            result += ((r[i] == 0) ? 0 : (r[i] << (32 - 1 - i)));
        }
        if (r[0] == 1) {
            return Integer.MIN_VALUE + result;
        } else {
            return result;
        }
    }
}
