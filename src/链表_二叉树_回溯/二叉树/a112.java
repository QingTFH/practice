package 链表_二叉树_回溯.二叉树;

public class a112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    public boolean dfs(TreeNode node, int sum, int target) {
        if (node == null)
            return false;

        // sum 是 path上(除了node本身)所有节点的和
        sum += node.val;

        if (sum == target && node.left == null && node.right == null)
            return true;

        return dfs(node.left, sum, target) || dfs(node.right, sum, target);
    }

}
