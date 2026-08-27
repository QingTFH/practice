package 网格图;

public class lcs03 {

    // 统计完面积后标为-1, 如果附近有0或者越界则不计入

    final int[][] dirs = { // 上下左右
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
    };

    public int largestArea(String[] grid) {
        int max = 0, n = grid.length, m = grid[0].length();
        int[][] g = new int[grid.length][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = grid[i].charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] > 0)
                    max = Math.max(dfs(g, i, j, g[i][j]), max);
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j, int t) {
        // 如果遇到0或越界, 返回-1
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) // 不继续计数
            return -1;

        // 如果遇到其他数字, 返回0
        if (grid[i][j] != t) // 不是目标情况
            return 0;

        int r = 1;
        grid[i][j] = -1;

        for (int x = 0; x < dirs.length; x++) {
            int temp = dfs(grid, i + dirs[x][0], j + dirs[x][1], t);
            if (temp == -1) // 该区域不计数, 但是依然要遍历完整个区域, 所以不立即返回
                r = -1;

            if (r != -1)
                r += temp;
        }
        return r;
    }

}
