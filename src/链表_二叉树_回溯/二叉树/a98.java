package 链表_二叉树_回溯.二叉树;

public class a98 {

    // 对于每一个节点, 我们需要判断: 它的左子树中的最大值是否小于它, 它的右子树的最小值是否大于它(自底向上构筑子树), 这就导致需要多个返回值
    // 假设左子树[min, max], 要求node > max -> 对于空节点, 要尽量让max小; 对于非法子树, 要尽量让max大; 右子树反之
    // 检查后, 更新并传回子树的[min, max]

    public boolean isValidBST(TreeNode root) {
        return dfs(root)[0] != Long.MIN_VALUE; // 不是非法情况
    }

    private long[] dfs(TreeNode node) {
        if (node == null) // null不计入判断, 需要返回一定成立的情况 -> 最小值一定更大, 最大值一定更小
            return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};

        long[] l = dfs(node.left); // [最小值, 最大值]
        long[] r = dfs(node.right);

        if (node.val > l[1] && node.val < r[0]) {
            long min = Math.min(Math.min(l[0], r[0]), node.val);
            long max = Math.max(Math.max(l[1], r[1]), node.val);
            return new long[]{min, max};
        }

        return new long[]{Long.MIN_VALUE, Long.MAX_VALUE}; // 一定不成立的情况
    }

    // 使用后序遍历, 本质是要检验node和左右子树范围的关系, 要求node夹在子树范围中间；
    // 如果使用前序遍历, 则是检验左右子树和node及其祖先范围的关系, 左孩子时传入范围的[Math.min(node, min), max], 右孩子则是更新max

}
