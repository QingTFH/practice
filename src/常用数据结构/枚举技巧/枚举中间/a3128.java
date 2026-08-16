package 常用数据结构.枚举技巧.枚举中间;

public class a3128 {

    // 遍历到grid[i]时, 仅考虑以它为直角边的交点的情况;
    // 那么, 它能组成的直角三角形个数为 水平方向上的点数 * 垂直方向上的点数, 因此可以预处理为两个一维数组

    public long numberOfRightTriangles(int[][] grid) {
        int[] hori = new int[grid.length]; // 水平方向上的1的个数
        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }
            hori[i] = sum;
        }

        int[] vert = new int[grid[0].length]; // 竖直方向上的1的个数
        for (int i = 0; i < grid[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < grid.length; j++) {
                sum += grid[j][i];
            }
            vert[i] = sum;
        }

        long result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    result += (long) (hori[i] - 1) * (vert[j] - 1);
                }
            }
        }

        return result;
    }
}
