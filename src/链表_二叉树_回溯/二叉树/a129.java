package 链表_二叉树_回溯.二叉树;

public class a129 {

    // node.val ∈ [0, 9], size >= 1
    // 自顶向下遍历路径, 一个num代表一个路径;
    // 遇到叶子节点的时候, 返回这一条路径的数字;
    // 返回两子树的返回值的和

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int num) {
        if (node == null)
            return 0;

        num = num * 10 + node.val; // path对应的num

        if (node.left == null && node.right == null) {
            return num;
        }

        int a = (node.left == null) ? 0 : dfs(node.left, num);
        int b = (node.right == null) ? 0 : dfs(node.right, num);

        return a + b;
    }

}
