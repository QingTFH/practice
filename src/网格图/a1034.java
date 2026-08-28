package 网格图;

public class a1034 {

    // 先找row, col所在的连通分量, 再对其边界染色
    // 直接dfs即可

    final int[][] dirs = { // 上下左右
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
    };

    int nc;
    int oc;
    int[][] visited;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.nc = color;
        this.oc = grid[row][col];
        visited = new int[grid.length][grid[0].length];
        if (oc != color)
            dfs(grid, row, col);

        return grid;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length ||
                (grid[i][j] != oc && visited[i][j] == 0)) // 越界情况 -> 天生的其他区域
            return false;

        if (visited[i][j] == 1) // 如果已经访问过这个位置了, 就不再重复访问
            return true;

        visited[i][j] = 1;

        // 判断当前位置是否是连通分块的边界 -> 有任意一边不属于连通分块 -> 有任意一边越界
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (!dfs(grid, x, y)) // 如果越界会返回false, 如果不越界会直接对其他位置进行操作, 注意此处会死循环, 需要visited数组
                grid[i][j] = nc;
        }

        return true;
    }



}
