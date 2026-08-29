package 链表_二叉树_回溯.回溯;

import java.util.ArrayList;

public class a2397 {

    // 回溯的本质是暴力
    // 对于每一列, 可以选择"覆盖"or not; 当覆盖了numSelect列后, 统计合法行的数量
    // 合法行: 该行中所有的1都被覆盖, 也就是拥有1的列数是numSelect的子集

    // 优化点: 可以用二进制数表示列选择情况(choose)和每行的1的情况(mask)
    // Integer.bitCount(choose) = choose中1的个数;
    // mask & choose = mask <-> mask被choose完全覆盖
    // 但这是朴素枚举, 不是回溯

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    int select; // 还应该选几列
    int col;    // 列的范围限制
    ArrayList<Integer> selects = new ArrayList<>();

    public int maximumRows(int[][] matrix, int numSelect) {
        col = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            int[] c = matrix[i];
            ArrayList<Integer> l = new ArrayList<>();   // 第i行的1的列数
            for (int j = 0; j < c.length; j++) {
                if (c[j] == 1)
                    l.add(j);
            }
            if (l.size() <= numSelect)  // 只有"<="才有可能被完全覆盖
                list.add(l);
        }
        select = numSelect;

        return dfs(0);
    }

    private int dfs(int index) {
        if (select == 0) {  // 统计覆盖了哪些行
            int r = 0;
            for (ArrayList<Integer> l : list) {
                boolean flag = true;
                for (int n : l) {
                    if (!selects.contains(n)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) r++;
            }
            return r;
        }

        if (index == col || col - index < select) {  // 不能选完numSelect列
            return 0;
        }

        int r = dfs(index + 1); // 不选第index列

        select --;
        selects.add(index); // 选第index列
        r = Math.max(r, dfs(index + 1));
        selects.remove((Object)index);
        select ++;

        return r;
    }

}
