package 链表_二叉树_回溯.二叉树;

public class a404 {



    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        // node有三种情况, 自己是叶子, 自己是左叶子的直接父, 自己是正常中间节点
        // 1. 自己是叶子, 但是自己无法知道自己是左还是右, 所以不应该向上传递数值
        // 2. 自己有左叶子, 那需要向上传递它的数值 -> isLeaf(node.left) ? node.left.val : 0
        // 3. 自己啥都不是, 那需要向上传递左右子树的数值 -> dfs(node.left) + dfs(node.right)

        return dfs(node.left) + dfs(node.right) + (isLeaf(node.left) ? node.left.val : 0);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

}
