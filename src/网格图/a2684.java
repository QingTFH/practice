package 网格图;

public class a2684 {

    // 假设我们找到了一条路径P1: a->b->c->d, 那还要把b/c/d当作入口吗？不用, 因为b->c->d和c->d都一定比P更短
    // 假设我们又找到一条路径P2: e->f->b, 此时你会发现又来到b了, 还要再遍历b->c->d吗? 如果记录了就不需要
    // 使用visited记录, 记录的值是"后续最长路径的长度"

    // 对于每个位置, 它对可达的位置获取它的最长路径长度, +1后返回

    int[][] grid;
    int[][] visited;
    final int[][] dirs = {
            {-1, 1}, {0, 1}, {1, 1},
    };


    public int maxMoves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        this.grid = grid;
        this.visited = new int[n][m];
        int r = 0;


        for (int i = 0; i < n; i++) {
            if (visited[i][0] == 0) // 只能从第1列出发
                r = Math.max(r, dfs(i, 0) - 1);
        }


        return r;
    }

    private int dfs(int i, int j) { // 不会进入不可达的位置
        if (visited[i][j] > 0)
            return visited[i][j];

        int r = 1; // 该位置下的最长路径(点数)
        int max = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] > grid[i][j])
                max = Math.max(dfs(x, y), max);
        }

        visited[i][j] = r + max;
        return r + max;
    }
}
