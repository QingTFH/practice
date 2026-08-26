package 链表_二叉树_回溯.二叉树;

import java.util.HashMap;

public class a437 {

    // 如何避免路径不被重复计算: 滑窗思想, 保证"是下一个合法窗口"依赖于"窗口一定包含之前没有出现过的节点"
    // 对应本题, 访问node时, 计算"包含node在内"的, root~node的路径中子路径的和 -> 固定右端点, 枚举左端点, 计算中间窗口的和
    //      -> 使用前缀和 + 遍历右,枚举左技巧

    HashMap<Long, Integer> map = new HashMap<>(); // 和 -> 次数
    long s = 0;
    int target;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        map.put(0L,1); // [0,x]前缀和 = sum[x] - sum[0], sum[0] = 0
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        s += node.val;
        int res = map.getOrDefault(s - target, 0); // sum[node] - sum[*] = targetSum -> sum[*] = sum[node] - targetSum, 取*的个数

        map.merge(s, 1, Integer::sum); // 由于map存的是"允许减去的值", 而node必须被保留, 因此map.merge需要放在res的计算之后
        int l = dfs(node.left);
        int r = dfs(node.right);

        map.merge(s, -1, Integer::sum);
        s -= node.val;

        return res + l + r;
    }

}
