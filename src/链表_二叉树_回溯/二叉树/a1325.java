package 链表_二叉树_回溯.二叉树;

public class a1325 {

    // 同814, 尝试删除自己

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null && root.val == target)
            return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target)
            return null;

        return root;
    }

}
