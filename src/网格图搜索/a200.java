package 网格图搜索;

public class a200 {

    public int numIslands(char[][] grid) {
        int ans = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                // 1. 遍历并找到一个"1"的位置
                if(grid[i][j] == '1') {
                    // 2. DFS并将所有连通的1置为0，计入一个岛屿数量
                    ans ++;
                    dfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public void dfs(char[][] grid, int x, int y) {
        // 把grid[x][y]及与其连通的'1'置为'0'

        // 1. 如果当前搜索到的位置是0, 直接返回
        if(!xyIsLegal(grid, x, y) || grid[x][y] == '0') {
            return;
        }

        // 2. 如果是1, 继续搜索四边
        grid[x][y] = '0';
        for (int i = 0; i < DIRS.length; i++) {
            dfs(grid, x + DIRS[i][0], y + DIRS[i][1]);
        }
    }

    public boolean xyIsLegal(char[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[x].length;
    }


}
