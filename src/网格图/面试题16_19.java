package 网格图;

import java.util.ArrayList;
import java.util.List;

public class 面试题16_19 {

    static final int[][] DIRS = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
            {1, -1}, {1, 1}, {-1, 1}, {-1, -1},
    };

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < land.length; i++){
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    list.add((int)dfs(land, i, j));
                }
            }
        }

        return list.stream().mapToInt(i -> i).sorted().toArray();
    }

    private long dfs(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] != 0)
            return 0;

        long r = 1;
        grid[i][j] = 1;

        for (int z = 0; z < DIRS.length; z++) {
            r += dfs(grid, i + DIRS[z][0], j + DIRS[z][1]);
        }
        return r;
    }

}
