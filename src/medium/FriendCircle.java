package medium;

import java.util.*;

public class FriendCircle {
    public static void main(String[] args) {
        final int[][] case1 = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(new Solution().findCircleNum(case1));

        final int[][] case2 = {
                {1,1,0},
                {1,1,1},
                {0,1,1}};
        System.out.println(new Solution().findCircleNum(case2));

        final int[][] case3 = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}};
        System.out.println(new Solution().findCircleNum(case3));

        final int[][] case4 = {
                {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                {0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
        System.out.println(new Solution().findCircleNum(case4));

        final int[][] case5 = {
                {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
        System.out.println(new Solution().findCircleNum(case5));
    }

    static class Solution {
        public int findCircleNum(int[][] M) {
            int n = M.length;
            if (n <= 0) {
                return 0;
            }

            if (n == 1) {
                return 1;
            }
            int[] visited = new int[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0) {
                    dfs(M, visited, i, n);
                    count++;
                }
            }

            return count;
        }

        private void dfs(int[][] M, int[] visited, int k, int n) {
            for (int i = 0; i < n; i++) {
                if (M[k][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    dfs(M, visited, i, n);
                }
            }
        }
    }
}
