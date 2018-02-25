package easy;

public class ToeplitzMatrix766 {
    public static void main(String[] args) {
        System.out.println(new ToeplitzMatrix766().isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
        System.out.println(new ToeplitzMatrix766().isToeplitzMatrix(new int[][]{{1,2},{2,2}}));
        System.out.println(new ToeplitzMatrix766().isToeplitzMatrix(new int[][]{{13},{66}}));
        System.out.println(new ToeplitzMatrix766().isToeplitzMatrix(new int[][]{{22,0,94,45,46,96},{10,22,80,94,45,46}}));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int verticalLen = matrix.length;
        if (verticalLen == 0) {
            return true;
        }

        int horizontalLen = matrix[0].length;
        for (int i = 1; i < verticalLen; i++) {
            if (matrix[i].length != horizontalLen) {
                return false;
            }
        }

        for (int i = 1; i < verticalLen; i++) {
            for (int j = 1; j < horizontalLen; j++) {
                if (matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
