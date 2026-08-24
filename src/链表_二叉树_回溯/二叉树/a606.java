package 链表_二叉树_回溯.二叉树;

public class a606 {

    // 题目描述太傻福了, 评论区有正常的描述
    // 对于节点node, 它要返回"root.val(root.left)(root.right)", 其中left和right是递归得到的字符串
    // 那就是自底向上构筑, 先获得左子树和右子树的字符串, 再套括号且拼接自己即可;
    // 需要注意的是, 空节点不使用括号嵌套, 除非左节点为空且右节点不为空, 此时为root.val()(root.right)

    public String tree2str(TreeNode root) { // 自底向上, 需要String拼接, 开销大
        if (root == null)
            return null;

        String l = tree2str(root.left);
        String r = tree2str(root.right);

        if (r != null && l == null)
            return root.val + "()" + "(" + r + ")";

        return root.val + (l == null ? "" : "(" + l + ")") + (r == null ? "" : "(" + r + ")");
    }

    StringBuilder sb = new StringBuilder();

    public String tree2str2(TreeNode root) { // 自顶向下, 使用StringBuilder, 开销小, 需要外置变量+辅助函数
        dfs(root);
        return sb.toString();
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;

        sb.append(node.val);
        if (node.left == null && node.right != null) {
            sb.append("()" + "(");
            dfs(node.right);
            sb.append(")");
        } else {
            if (node.left != null) {
                sb.append("(");
                dfs(node.left);
                sb.append(")");
            }

            if (node.right != null) {
                sb.append("(");
                dfs(node.right);
                sb.append(")");
            }
        }
    }

}
