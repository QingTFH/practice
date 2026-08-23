package 链表_二叉树_回溯.二叉树;

public class a111 {

    public int minDepth(TreeNode root) {
        return root == null ? 0 : dfs2(root);
    }

    private int dfs2(TreeNode node) { // 不传depth参数的写法, 自底向上
        if (node == null)
            return -1;

        if (node.left == null && node.right == null)
            return 1; // 有基础深度

        if (node.left == null) {
            return dfs2(node.right) + 1; // 子树的叶子的深度, 在此层再+1
        } else if (node.right == null) {
            return dfs2(node.left) + 1;
        }

        return Math.min(dfs2(node.right), dfs2(node.left)) + 1;
    }

    private int dfs(TreeNode node, int depth) { // 自顶向下
        // depth是node当前的深度

        if (node == null) // 空节点不能计算深度
            return -1;

        if (node.left == null && node.right == null) // 是叶子节点, 可以称为"深度"
            return depth;

        // 在两子树的合法叶子深度间 选择较小的深度
        int a = dfs(node.left, depth + 1);
        int b = dfs(node.right, depth + 1);
        return filter(a, b);
    }

    private int filter(int a, int b) {
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
}
