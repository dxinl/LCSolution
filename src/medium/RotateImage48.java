package medium;

import java.util.Arrays;

public class RotateImage48 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateImage48 rotateImage48 = new RotateImage48();
        rotateImage48.rotate(matrix);
        rotateImage48.print(matrix);
        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateImage48.rotate(matrix);
        rotateImage48.print(matrix);
        matrix = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        rotateImage48.rotate(matrix);
        rotateImage48.print(matrix);
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length <= 1) {
            return;
        }

        int li = length - 1;
        int k, l;
        for (int i = 0; i <= (li >> 1); i++) {
            for (int j = i; j < li - i; j++) {
                k = i;
                l = li - j;
                int tmp = matrix[k][l];
                matrix[k][l] = matrix[Math.abs(l - li)][k];
                matrix[Math.abs(l - li)][k] = matrix[Math.abs(k - li)][Math.abs(l - li)];
                matrix[Math.abs(k - li)][Math.abs(l - li)] = matrix[Math.abs(Math.abs(l - li) - li)][Math.abs(k - li)];
                matrix[Math.abs(Math.abs(l - li) - li)][Math.abs(k - li)] = tmp;
            }
        }
    }

    private void print(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            System.out.println(Arrays.toString(aMatrix));
        }
    }
}
