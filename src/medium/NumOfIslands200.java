package medium;

public class NumOfIslands200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] cs = grid[i];
            for (int j = 0; j < cs.length; j++) {
                if (cs[j] == 'x' || cs[j] == '0') {
                    continue;
                }

                count++;
                travel(i, j, grid);
            }
        }

        return count;
    }

    private void travel(int x, int y, char[][] grid) {
        if (grid[x][y] == '1') {
            grid[x][y] = 'x';
        } else {
            return;
        }

        if (x > 0) {
            travel(x - 1, y, grid);
        }

        if (x < grid.length - 1) {
            travel(x + 1, y, grid);
        }

        if (y > 0) {
            travel(x, y - 1, grid);
        }

        if (y < grid[x].length - 1) {
            travel(x, y + 1, grid);
        }
    }
}
