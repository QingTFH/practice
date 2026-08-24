package 链表_二叉树_回溯.二叉树;

public class a2265 {

    // 要同时传递"子树右几个节点", "子树的和"两个信息, 使用数组

    int result = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[]{0, 0};

        int[] data = dfs(node.left);
        int[] d2 = dfs(node.right);
        data[0] += d2[0] + node.val;    // 树的和
        data[1] += d2[1] + 1;           // 树的节点数

        if (data[0] / data[1] == node.val)
            result ++;

        return data;
    }

}
