package 链表_二叉树_回溯.二叉树;

import java.util.HashSet;
import java.util.Set;

public class a1339 {

    // 所谓"拆分成两棵树", 由于根节点一定在其中一棵树中, 因此是自顶向上构建子树, 计算可能的子树和sum_i; 与此同时计算整棵树的总和;
    // 两颗子树的和, 相当于sum_i 和 sum_total - sum_i, 遍历即可

    Set<Integer> sumOfChildTree = new HashSet<>();

    public int maxProduct(TreeNode root) {
        int sumTotal = dfs(root);
        long max = 0;
        for (int s : sumOfChildTree) {
            max = Math.max(max, ((long)sumTotal - (long)s) * (long)s);
        }

        return (int)(max % 1_000_000_007);
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);
        int sum = l + r + node.val;

        sumOfChildTree.add(sum);
        return sum;
    }

}
