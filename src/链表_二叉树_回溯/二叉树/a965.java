package 链表_二叉树_回溯.二叉树;

public class a965 {

    int target;

    public boolean isUnivalTree(TreeNode root) {
        target = root.val;
        return dfs(root);
    }

    private boolean dfs(TreeNode node) {
        if (node == null)
            return true;

        if (node.val != target)
            return false;

        return dfs(node.left) && dfs(node.right); // &是布尔求值, 需要完整计算出两个数; &&是短路逻辑, 只要前者为假就直接返回
    }

}
