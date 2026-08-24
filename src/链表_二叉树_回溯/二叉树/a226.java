package 链表_二叉树_回溯.二叉树;

public class a226 {

    // 对于每个节点, 交换它的左右子树;

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);

        root.left = r;
        root.right = l;

        return root;
    }

}
