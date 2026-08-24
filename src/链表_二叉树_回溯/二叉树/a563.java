package 链表_二叉树_回溯.二叉树;

public class a563 {

    // 统计每个节点的坡度的和, 每个节点的坡度是每个节点的左右子树的和的差值的绝对值, 因此统计每个节点左右子树的和

    int result = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);

        result += Math.abs(l - r);

        return l + r + node.val;
    }

}
