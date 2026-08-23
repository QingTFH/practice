package 链表_二叉树_回溯.二叉树;

public class a104 {

    public int maxDepth(TreeNode root) {
        return dfs(root, 1);
    }

    private int dfs(TreeNode node, int depth) {
        // depth是node当前的深度

        if (node == null) // 空节点不能计算深度, 如果root = null, 深度是0
            return 0;

        if (node.left == null && node.right == null) // 是叶子节点, 可以称为"深度"
            return depth;

        // 在两子树的叶子深度间 选择较大的深度
        return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
    }

}
