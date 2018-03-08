package medium;

public class Search2DMatrixII240 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}/*,
                {18, 21, 23, 26, 30}*/
        };
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 5));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 22));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 26));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 19));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 23));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 21));

        matrix = new int[][]{
                {1, 3, 5, 7, 9},
                {2, 4, 6, 8, 10},
                {11, 13, 15, 17, 19},
                {12, 14, 16, 18, 20},
                {21, 22, 23, 24, 25}};
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 1));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 2));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 11));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 12));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 21));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 3));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 4));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 13));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 14));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 22));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 5));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 6));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 15));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 16));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 23));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 7));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 8));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 17));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 18));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 24));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 9));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 10));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 19));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 20));
        System.out.println(new Search2DMatrixII240().searchMatrix(matrix, 25));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        if (matrix[0].length == 0) {
            return false;
        }

        if (target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }

        int row = matrix.length - 1;
        int col = 0;
        boolean searchRow = true;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (searchRow) {
                if (matrix[row][col] > target) {
                    row--;
                } else {
                    searchRow = false;
                    col++;
                }
            } else {
                if (matrix[row][col] < target) {
                    col++;
                } else {
                    searchRow = true;
                    row--;
                }
            }
        }
        return false;
    }
}
