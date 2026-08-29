package 网格图;

public class a1391 {

    // 对于每个位置, 根据自己的数字, 探查可达的位置, 判断"能否进入"
    // 一个位置只能"来"和"去", 两个方向

    final int[][] dirs = { // 左, 有, 上, 下
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
    };

    final int[][] streets = {    // street = i+1 时, 该位置可达方向dirs[street[i][*]]
            {0, 1}, {2, 3}, {0, 3}, {1, 3}, {0, 2}, {1, 2}
    };

    int[][] g;
    boolean[][] visited;

    public boolean hasValidPath(int[][] grid) {
        g = grid;
        visited = new boolean[g.length][g[0].length];
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || visited[i][j])
            return false;

        if (i == g.length - 1 && j == g[0].length - 1)
            return true;

        visited[i][j] = true;

        // 找到自己这个位置可达的, 未访问过的点
        // 可达: 自己可以过去, 对面可以接受
        for (int n : streets[g[i][j] - 1]) {
            int[] dir = dirs[n];
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= g.length || y < 0 || y >= g[0].length || visited[x][y])
                continue;

            // 自己的方向是dir, 要判断对方有没有-dir, 也就是0 <-> 1, 2 <-> 3
            int reverse = n ^ 1; // reverse <-> n 匹配
            for (int nextDirIdx : streets[g[x][y] - 1]) { // 对方的方向
                if (nextDirIdx == reverse) { // 对方拥有reverse方向
                    if (dfs(x, y)) return true;
                    break;
                }
            }
        }

        return false;
    }



}
