package 链表_二叉树_回溯.二叉树;

public class a2331 {



    public boolean evaluateTree(TreeNode root) {
        if (isLeaf(root))
            return root.val == 1;

        return root.val == 2 ? evaluateTree(root.left) || evaluateTree(root.right)
                : evaluateTree(root.left) && evaluateTree(root.right);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
