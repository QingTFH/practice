package 链表_二叉树_回溯.回溯;

import java.util.Arrays;

public class a3566 {

    // 要求划分成两个乘积均为target的子集, 实际上是"总积为target ** 2, 并且选出一个子集, 乘积为target"

    long mult = 1;
    int[] ns;
    long tar;

    public boolean checkEqualPartitions(int[] nums, long target) {
        long mult = 1;
        for (int i : nums)
            mult *= i;

        if (mult != target * target)
            return false;

        // 尝试找到一个mult = target的子集, 选orn法
        ns = nums;
        tar = target;
        return dfs(0);
    }

    private boolean dfs(int index) {
        if (mult > tar)  // nums[i] >= 1, 因此一旦大于就不可能回归相等, 剪枝
            return false;

        if (mult == tar)
            return true;

        if (index == ns.length) // 空节点
            return false;

        if (dfs(index + 1)) // 不选
            return true;

        mult *= ns[index];
        boolean r = dfs(index + 1); // 选
        mult /= ns[index];
        return r;
    }

}
