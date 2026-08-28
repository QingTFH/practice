package 网格图;

public class a130 {

    char[][] board;
    boolean[][] visited;
    final int[][] dirs = { // 上下左右
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
    };

    public void solve(char[][] board) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!visited[i][j] && board[i][j] == 'O' && dfs(i, j) != -1) {
                    dfs2(i, j);
                }
            }
        }
    }

    private int dfs(int i, int j) {     // 搜索用dfs
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length)
            return -1;  // 非法连通块

        if (board[i][j] == 'X' || visited[i][j])
            return 0;   // 合法边界 或者 访问过的位置

        visited[i][j] = true;
        int r = 0;
        for (int[] dir : dirs) {
            if (dfs(i + dir[0], j + dir[1]) == -1)
                r = -1;
        }
        return r;
    }

    private void dfs2(int i, int j) {   // 修改用dfs
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 'X')
            return;

        board[i][j] = 'X';
        for (int[] dir : dirs)
            dfs2(i + dir[0], j + dir[1]);
    }

}
