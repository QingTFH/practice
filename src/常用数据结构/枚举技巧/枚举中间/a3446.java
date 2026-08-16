package 常用数据结构.枚举技巧.枚举中间;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class a3446 {

    // n*n 方阵一共有 2*n - 1 条对角线, 其中前n条是左下角, 后n-1条是右上角
    // 首坐标为(max(0, -n + i), max(0,n - i)) ((x, y)而不是(i, j))
    // 每次遍历一条对角线, 先遍历一次获得所有元素, 排序后再遍历一次放回所有元素

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n][n]; // 避免副作用
        for(int i = 1; i < 2 * n; i++) { // i代表第i条对角线
            // 1. 获取对角线上的元素
            int baseJ = Math.max(0, -n + i);
            int baseI = Math.max(0, n - i);
            ArrayList<Integer> list = new ArrayList<>();
            for(int tmpI = baseI, tmpJ = baseJ; tmpI < n && tmpJ < n; tmpI++, tmpJ++) {
                list.add(grid[tmpI][tmpJ]);
            }

            // 2. 排序(前n条降序排序, 后n-1条升序排序)
            if(i <= n) {
                Collections.sort(list, Collections.reverseOrder());
            } else {
                Collections.sort(list, Comparator.naturalOrder());
            }

            // 3. 放入result中
            for(int tmpI = baseI, tmpJ = baseJ, cnt = 0; tmpI < n && tmpJ < n; tmpI++, tmpJ++, cnt++) {
                result[tmpI][tmpJ] = list.get(cnt);
            }
        }


        return result;
    }

}
