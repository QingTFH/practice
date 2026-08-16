package 网格图搜索;

public class a695 {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        // 在a200的基础上, 统计岛屿的面积

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                // 1. 遍历并找到一个"1"的位置
                if(grid[i][j] == 1) {
                    // 2. DFS并将所有连通的1置为0，统计它的面积
                    max = Math.max(max, dfs(grid, i, j, 0));
                }
            }
        }

        return max;

    }

    static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int dfs(int[][] grid, int x, int y, int area) {
        // 把grid[x][y]及与其连通的'1'置为'0', 给面积+1

        // 1. 如果当前搜索到的位置是0或者越界, 直接返回
        if(!xyIsLegal(grid, x, y) || grid[x][y] == 0) {
            return 0;
        }

        // 2. 如果是1, 给已统计的面积+1, 并继续搜索四边
        area += 1;
        grid[x][y] = 0;
        for (int i = 0; i < DIRS.length; i++) {
            area += dfs(grid, x + DIRS[i][0], y + DIRS[i][1], 0);
        }
        return area;
    }

    public boolean xyIsLegal(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[x].length;
    }


}
