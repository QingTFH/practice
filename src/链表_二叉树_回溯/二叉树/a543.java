package 链表_二叉树_回溯.二叉树;

public class a543 {

    // 对于每个节点node, 它会串联两条路径, 长度分别为a, b(也就是leaf1 -> node = a, leaf2 -> node = b), 此时路径长度为a+b+1
    // 那么对于每个节点node, 只要知道它左子树中最长路径和右子树中最长路径即可, 其实也就是最深叶子的深度

    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        int l = dfs(node.left); // 两子树的最深叶子深度, 由于叶子深度为1, 路径长 = 深度 - 1
        int r = dfs(node.right);

        result = Math.max(result, l + r); // 由于路径长度不取决于点数, 因此没有重叠部分, 不-1
        return Math.max(l, r) + 1;
    }

}
