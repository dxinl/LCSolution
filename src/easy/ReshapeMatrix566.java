package easy;

public class ReshapeMatrix566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0) {
            return nums;
        }
        
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        
        int[][] matrix = new int[r][c];
        int mRow = 0;
        int mColumn = 0;

        for (int[] num : nums) {
            for (int aNum : num) {
                matrix[mRow][mColumn] = aNum;
                mColumn++;
                if (mColumn == c) {
                    mRow++;
                    mColumn = 0;
                }
            }
        }
        return matrix;
    }
}
