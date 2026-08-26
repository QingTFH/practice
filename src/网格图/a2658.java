package 网格图;

public class a2658 {

    // 只要是水域就可以行走, 本质和3619一致

    public int findMaxFish(int[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    result = Math.max(result, (int)dfs(grid, i, j));
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
