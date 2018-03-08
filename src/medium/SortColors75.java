package medium;

import java.util.Arrays;

public class SortColors75 {
    public static void main(String[] args) {
        SortColors75 colors75 = new SortColors75();
        int[] colors = new int[]{2,1,2,1,0};
        colors75.sortColors(colors);
        System.out.println(Arrays.toString(colors));
        colors = new int[]{0,0};
        colors75.sortColors(colors);
        System.out.println(Arrays.toString(colors));
        colors = new int[]{0,1};
        colors75.sortColors(colors);
        System.out.println(Arrays.toString(colors));
        colors = new int[]{1,2,1};
        colors75.sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }

    public void sortColors(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int red = 0, white = 0, blue = 0;
        for (int n : nums) {
            switch (n) {
                case 0:
                    red++;
                    break;

                case 1:
                    white++;
                    break;

                case 2:
                    blue++;
                    break;
            }
        }

        int redStart = 0, whiteStart = red, blueStart = red + white;
        for (int i = 0; i < red; i++) {
            if (nums[i] == 0) {
                redStart++;
            } else {
                break;
            }
        }
        for (int i = whiteStart; i < blueStart; i++) {
            if (nums[i] == 1) {
                whiteStart++;
            } else {
                break;
            }
        }

        for (int i = blueStart; i < nums.length; i++) {
            if (nums[i] == 2) {
                blueStart++;
            } else {
                break;
            }
        }

        int index;
        if (red != 0) {
            index = redStart;
        } else if (white != 0) {
            index = whiteStart;
        } else {
            return;
        }
        if (index == nums.length) {
            return;
        }

        while (true) {
            boolean next = false;
            if (index < red && nums[index] == 0) {
                next = true;
                redStart++;
            } else if (index >= red && index < red + white && nums[index] == 1) {
                next = true;
                whiteStart++;
            } else if (index >= red + white && nums[index] == 2) {
                next = true;
                blueStart++;
            }

            if (next) {
                if (redStart < red) {
                    index = redStart;
                } else if (whiteStart < red + white) {
                    index = whiteStart;
                } else {
                    return;
                }
                continue;
            }

            int tmp;
            switch (nums[index]) {
                case 2:
                    tmp = nums[blueStart];
                    nums[blueStart++] = 2;
                    nums[index] = tmp;
                    break;

                case 1:
                    tmp = nums[whiteStart];
                    nums[whiteStart++] = 1;
                    nums[index] = tmp;
                    break;
            }
        }
    }
}
