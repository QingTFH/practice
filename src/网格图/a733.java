package 网格图;

public class a733 {

    final int[][] dirs = { // 上下左右
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
    };

    int oc;
    int nc;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        nc = color;
        oc = image[sr][sc];
        if (oc != nc)
            dfs(image, sr, sc);
        return image;
    }

    public void dfs(int[][] image, int i, int j) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != oc)
            return;

        image[i][j] = nc;
        for (int[] dir : dirs) {
            dfs(image, i + dir[0], j + dir[1]);
        }
    }

}
