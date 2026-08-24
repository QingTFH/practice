package 链表_二叉树_回溯.二叉树;

public class a1026 {

    // 向下传递这条路径上的最大值和最小值, 更新答案

    int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return result;
    }

    private void dfs(TreeNode node, int max, int min) {
        if (node == null) {
            result = Math.max(result, max-min); // 优化点: 在空节点(底部)更新result即可, 此时max和min一定是路径上的最值
            return;
        }

        max = Math.max(node.val, max);
        min = Math.min(node.val, min);

        dfs(node.left, max, min);
        dfs(node.right, max, min);
    }

}
