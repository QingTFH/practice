package 网格图;

public class a1020 {

    // 不与边界相邻的连通块的大小和 -> dfs计算连通块的大小, 如果与边界相邻则为非法情况, 不计入

    int[][] grid;

    final int[][] dirs = { // 上下左右
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
    };

    public int numEnclaves(int[][] grid) {
        int r = 0;
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    int t = dfs(i, j);
                    if (t != -1)
                        r += t;
                }
            }
        }

        return r;
    }

    private int dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
            return -1;  // 出界, 非法情况

        if (grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;

        int r = 1;
        for (int[] dir : dirs) {
            int t = dfs(i + dir[0], j + dir[1]);
            if (t == -1 || r == -1)
                r = -1;
            else
                r += t;
        }
        return r;
    }

}
