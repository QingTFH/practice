package 链表_二叉树_回溯.二叉树;

public class a617 {

    // 同时遍历三颗树: r1, r2和result即可
    // 访问一个位置时, 需要直接处理完左右孩子

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode rD = new TreeNode(0, null, null),
                d1 = new TreeNode(0, root1, null),
                d2 = new TreeNode(0, root2, null);

        dfs(d1, d2, rD);

        return rD.left;
    }

    public void dfs(TreeNode root1, TreeNode root2, TreeNode result) {
        // 保证这个位置不全为空
        if (root1 == null)
            root1 = new TreeNode(0);

        if (root2 == null)
            root2 = new TreeNode(0);

        if (root1.left != null || root2.left != null) { // 创建左孩子并继续dfs
            int l1 = root1.left == null ? 0 : root1.left.val;
            int l2 = root2.left == null ? 0 : root2.left.val;
            result.left = new TreeNode(l1 + l2);
            dfs(root1.left, root2.left, result.left);
        }

        if (root1.right != null || root2.right != null) { // 创建右孩子并继续dfs
            int r1 = root1.right == null ? 0 : root1.right.val;
            int r2 = root2.right == null ? 0 : root2.right.val;
            result.right = new TreeNode(r1 + r2);
            dfs(root1.right, root2.right, result.right);
        }
    }

}
