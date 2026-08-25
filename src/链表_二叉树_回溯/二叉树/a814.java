package 链表_二叉树_回溯.二叉树;

public class a814 {

    // 自底向上操作: 先将该节点的枝剪完, 再向上更新该节点
    // 如果是null, 需要被删除; 如果是叶子0, 需要被删除; 如果非叶子, 将左节点更新为操作后的左节点, 右节点同理

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) // 判断自己需不需要被剪
            return null;
        if (root.left == null && root.right == null && root.val == 0)
            return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0)
            return null;

        return root;
    }

}
