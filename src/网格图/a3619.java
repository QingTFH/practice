package 网格图;

public class a3619 {

    // 搜索到非0位置时, 计算整个岛屿的分数并都标记为0(已访问)
    // 依旧要注意数据爆int的问题

    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int countIslands(int[][] grid, int k) {
        int result = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    if (dfs(grid, i, j) % k == 0)
                        result++;
                }
            }
        }

        return result;
    }

    private long dfs(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] == 0)
            return 0;

        long r = grid[i][j];
        grid[i][j] = 0;

        return r +
                dfs(grid, i+1, j) +
                dfs(grid, i, j+1) +
                dfs(grid, i-1, j) +
                dfs(grid, i, j-1);
    }

}
