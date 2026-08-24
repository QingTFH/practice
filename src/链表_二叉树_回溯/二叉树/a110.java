package 链表_二叉树_回溯.二叉树;

public class a110 {

    // 对于每个节点, 找到两子树的最大深度即可, 但这会占用返回值, 因此返回值不能使用boolean -> 使用全局boolean变量 + 辅助dfs函数

    // 看了题解, 可以将非法情况的返回值设为非法值, 当接受到非法值时就可以认为存在非法子树, 因此继续传递非法值

    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0; // -1和0无所谓

        if (node.left == null && node.right == null)
            return 1;

        int l = dfs(node.left);
        int r = dfs(node.right); // 左右子树的高度
        if (Math.abs(l - r) > 1)
            result = false;

        return Math.max(l, r) + 1;
    }

}
