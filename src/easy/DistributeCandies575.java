package easy;

public class DistributeCandies575 {
    public int distributeCandies(int[] candies) {
        int sum = candies.length >> 1;
        int count = 0;
        int[] candiesSister = new int[200001];
        for (int i = 0; i < candies.length; i++) {
            int index = candies[i] + 100000;
            if (candiesSister[index] == 0) {
                candiesSister[index]++;
                count++;
            }

            if (count == sum) {
                break;
            }
        }

        return count;
    }
}
