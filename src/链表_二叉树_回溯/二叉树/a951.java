package 链表_二叉树_回溯.二叉树;

public class a951 {

    // 类似971, 不过应该进行同步遍历; 那就类似100

    // 两棵树翻转等价, 意味着根节点相同, 并且如果左右子树值相同, 则左右子树翻转等价; 如果左右子树值相反, 则翻转后左右子树翻转等价;
    // 相当于判断左右子树是否翻转等价, 以及翻转后是否翻转等价

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) // 翻转前
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)); // 翻转后
    }

}
