package 链表_二叉树_回溯.回溯;

public class a2212 {

    // 本质lcp51, 选座"是否获得区域i的分数", 然后cost = aliceArrows[i] + 1
    // 当然, 0分区域就不用射了;
    // 如果最后剩余箭矢, 全部放在最后一格即可

    // 可不可以用二进制数来做呢? 我没想到优化的点
    // 看了题解：可以在dfs中不更新答案, 而是只用12位mask记录选择了哪些区域, 最后统一更新答案

    int[] result;
    int[] aliceArrows;
    int max = 0;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        this.aliceArrows = aliceArrows;
        dfs(1, 0, new int[12], numArrows);
        return result;
    }

    private void dfs(int index, int sum, int[] bobArrows, int costLeft) {
        if (index == 12) {   // 所有区域讨论结束
            if (sum > max) {    // 可以更新答案
                max = sum;
                result = bobArrows.clone();
                if (costLeft > 0) {
                    result[11] += costLeft;
                }
            }
            return;
        }

        // 不选index
        dfs(index + 1, sum, bobArrows, costLeft);

        // 选index
        int aliceArrow = aliceArrows[index];
        if (costLeft > aliceArrow) {
            bobArrows[index] = aliceArrow + 1;  // 布置现场
            dfs(index + 1, sum + index, bobArrows, costLeft - aliceArrow - 1);
            bobArrows[index] = 0;   // 回溯现场
        }
    }

}
