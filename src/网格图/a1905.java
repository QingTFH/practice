package 网格图;

public class a1905 {

    // 对于g2的一个连通块, 如果它的所有位置在g1中都是陆地, 那么就是合法连通块; 计算合法连通块的个数

    int[][] g1, g2;
    int n, m;
    final int[][] dirs = { // 上下左右
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
    };

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        g1 = grid1;     g2 = grid2;     n = g1.length;      m = g1[0].length;
        int r = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g2[i][j] > 0 && dfs(i, j))
                    r ++;
            }
        }

        return r;
    }

    private boolean dfs(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || g2[i][j] == 0)
            return true;

        boolean r = g1[i][j] == 1;
        g2[i][j] = 0;

        for (int[] dir : dirs) {
            if (!dfs(i + dir[0], j + dir[1]))
                r = false;
        }

        return r;
    }



}
