package easy;

public class NumberComplement476 {
    public static void main(String[] args) {
        System.out.println(new NumberComplement476().findComplement(1));
    }

    public int findComplement(int num) {
        int result = 0;
        int count = 1;
        while (num >= 1) {
            int i = num & 1;
            result += (i ^ 1) * count;
            count *= 2;
            num >>= 1;
        }
        return result;
    }
}
