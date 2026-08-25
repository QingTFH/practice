package 链表_二叉树_回溯.二叉树;

public class a572 {

    // 自底向上枚举每颗子树, 并与subRoot比较? 但是判断是否相等依然是O(m)级, 所以总复杂度是O(m*n)级的

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;

        if (root == null) // 这一边走不通了
            return false;

        return isEqual(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isEqual(TreeNode r, TreeNode r2) {
        if (r == null && r2 == null)
            return true;

        if (r == null || r2 == null || r.val != r2.val)
            return false;

        return isEqual(r.left, r2.left) && isEqual(r.right, r2.right);
    }

}
