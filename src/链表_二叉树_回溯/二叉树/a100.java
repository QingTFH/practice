package 链表_二叉树_回溯.二叉树;

public class a100 {

    // 两棵树相同, 当且仅当 根节点的值相同 且 左右两颗子树相同

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) // 都是null
            return true;

        if (p == null || q == null) // 只有一个null
            return false;

        if (p.val != q.val) // 根节点不同
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); // 左右子树的情况
    }

}
