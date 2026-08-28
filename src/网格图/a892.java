package 网格图;

public class a892 {

    // 每个位置有多少贡献呢? -> 露出的面数 -> 对于底/顶，一定会露出; 对于四面, 取差值或0

    final int[][] dirs = { // 上下左右
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
    };

    public int surfaceArea(int[][] grid) {
        int r = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                r += count(grid, i, j);
            }
        }

        return r;
    }

    private int count(int[][] grid, int i, int j) {
        if (grid[i][j] == 0)
            return 0;

        int r = 2; // 底 + 顶

        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[i].length)
                r += grid[i][j];
            else
                r += Math.max(0, grid[i][j] - grid[x][y]);
        }

        return r;
    }

}
