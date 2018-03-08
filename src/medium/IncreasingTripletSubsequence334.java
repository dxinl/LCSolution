package medium;

public class IncreasingTripletSubsequence334 {
    public static void main(String[] args) {
        System.out.println(new IncreasingTripletSubsequence334().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new IncreasingTripletSubsequence334().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new IncreasingTripletSubsequence334().increasingTriplet(new int[]{4, 5, 3, 7, 1}));
        System.out.println(new IncreasingTripletSubsequence334().increasingTriplet(new int[]{4, 5, 1, 2, 3}));
        System.out.println(new IncreasingTripletSubsequence334().increasingTriplet(new int[]{5, 1, 5, 5, 2, 5, 4}));
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        boolean foundFirst2 = false;
        int k = nums[0], l = 0, m = k;
        for (int i = 1; i < nums.length; i++) {
            if (!foundFirst2) {
                if (k < nums[i]) {
                    m = k;
                    foundFirst2 = true;
                    l = nums[i];
                }
                k = nums[i];
            } else {
                if (nums[i] > k) {
                    return true;
                }

                if (nums[i] < k && nums[i] > m) {
                    k = nums[i];
                    l = nums[i];
                } else if (l > nums[i]) {
                    l = nums[i];
                } else if (l < nums[i]) {
                    k = l = nums[i];
                }
            }
        }
        return false;
    }
}
