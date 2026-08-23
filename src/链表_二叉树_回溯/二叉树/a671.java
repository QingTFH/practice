package 链表_二叉树_回溯.二叉树;

import java.util.stream.IntStream;

public class a671 {

    // root.val == min(root.left.val, root.right.val), val > 0
    // 每个节点的出度固定为0或2;

    // 返回比root大的值中最小的
    // 快速剪枝: 如果当前节点已经大于root.val, 直接返回当前节点的值, 因为两侧的子节点一定大于等于

    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int min) {
        if (node == null)
            return -1;

        if (node.val > min)
            return node.val;

        return filter2(dfs(node.left, min), dfs(node.right, min));
    }

    private int filter2(int a, int b) {
        // 返回a, b中, 不是-1且较小的那个, 否则返回-1
        // if-else开销较小, 但是更丑陋
        if (a == -1 && b == -1)
            return -1;
        else if (a == -1)
            return b;
        else if (b == -1)
            return a;
        else
            return Math.min(a, b);
    }

    private int filter(int a, int b) {
        // 返回a, b中, 不是-1且较小的那个, 否则返回-1
        // stream式运算开销较大
        return IntStream.of(a, b)     // 创建stream
                .filter(x -> x > 0)     // 筛选大于0的x
                .min()                      // 获得流中的最小值, 如果没有则返回null
                .orElse(-1);          // 如果是null, 返回other

    }

}
