package 网格图;

public class a1254 {

    // 对于一个目标连通块, 它的边界全是1而非越界; 相对应的, 如果它存在一个边界为越界的位置, 他就是非法连通块

    int[][] grid;
    final int[][] dirs = { // 上下左右
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
    };

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        int r = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && dfs(i, j) != -1) {
                    r ++;
                }
            }
        }

        return r;
    }

    private int dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
            return -1;  // 非法连通块

        if (grid[i][j] == 1)
            return 0;   // 合法边界 或者 访问过的位置

        grid[i][j] = 1; // 因为访问过的位置和合法边界效果等同, 不用设置成其他数
        int r = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (dfs(x, y) == -1)
                r = -1;
        }
        return r;
    }

}
