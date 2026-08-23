package 链表_二叉树_回溯.二叉树;

public class a623 {

    // 找到depth - 1的层

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode dummy = new TreeNode(-1, root, null); // depth = 0
        dfs(dummy, 0, val, depth);
        return dummy.left;
    }

    private void dfs(TreeNode node, int depth, int val, int targetDepth) {
        // 当前节点node, 节点深度depth
        if(node == null)
            return;

        if (depth < targetDepth - 1) {
            dfs(node.left, depth+1, val, targetDepth);
            dfs(node.right, depth+1, val, targetDepth);
        } else {
            // depth == targetDepth - 1
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        }
    }

}
