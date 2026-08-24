package 链表_二叉树_回溯.二叉树;

public class a1372 {

    // DFS时, 进入节点node, 我们知道进入的方向dir(false为左, true为右)

    public int longestZigZag(TreeNode root) {
        if (root.left == null && root.right == null)
            return 0;
        return Math.max(dfs(root.left, false, 1), dfs(root.right, true, 1));
    }

    public int dfs(TreeNode node, boolean dir, int path) {
        // path是计入了node的路径长度

        if (node == null)
            return -1;

        int l, r;
        if (dir) {
            l = dfs(node.left, false, path + 1);
            r = dfs(node.right, true, 1); // node和node的孩子的路径是1
        }
        else {
            l = dfs(node.left, false, 1);
            r = dfs(node.right, true, path + 1);
        }

        return Math.max(path, Math.max(l, r));
    }

}
