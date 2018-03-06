package medium;

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] result = new int[m][n];
        result[0][1] = 1;
        result[1][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i-1][j] + result[i][j-1];
                }
            }
        }

        return result[m-1][n-1];
    }
}
