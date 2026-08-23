package 链表_二叉树_回溯.二叉树;

public class a1022 {

    // node.val = 0 or 1, size >= 1
    // path -> num: (num << 1) + node.val

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int num) {
        if (node == null)
            return 0;

        num = (num << 1) + node.val; // path对应的num

        if (node.left == null && node.right == null) {
            return num;
        }

        int a = (node.left == null) ? 0 : dfs(node.left, num);
        int b = (node.right == null) ? 0 : dfs(node.right, num);

        return a + b;
    }

}
