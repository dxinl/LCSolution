package easy;

public class ReverseBits190 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(new ReverseBits190().reverseBits(3)));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int c = 0;
        int result = 0;
        while (c < 32) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
            c++;
        }
        return result;
    }
}
