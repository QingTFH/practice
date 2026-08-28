package 网格图;

public class a463 {

    final int[][] dirs = { // 上下左右
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
    };

    // 已访问过的位置记为-1; 对于一个位置,我们要计算它贡献了多少周长, 因此要先访问它的四方; 如果该方向是水, 贡献+1; 否则不增加贡献
    // 保证是一块完整的岛屿, 合法位置 = 1

    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] <= 0)
            return 0;

        grid[i][j] = -1;
        int r = 0;

        for (int k = 0; k < dirs.length; k++) {
            int x = i + dirs[k][0], y = j + dirs[k][1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[i].length || grid[x][y] == 0) {
                r++;
            }
            r += dfs(grid, x, y);
        }

        return r;
    }

}
