package 链表_二叉树_回溯.二叉树;

public class a101 {

    // 两棵树对称, 当且仅当 根节点的值相同, 且 两课树的子树互相对称
    // 对称和相同的区别为, 镜像是左右颠倒的相同, 也就是左的左边等于右的右边 -> l往左搜索的时候, r往右搜索
    // 和100的区别在于, 100是两边都"中左右", 101是左边"中左右", 右边"中右左"

    public boolean isSymmetric(TreeNode root) {
        return filter(root.left, root.right);
    }

    private boolean filter(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;

        if (l == null || r == null)
            return false;

        if (l.val != r.val)
            return false;

        return filter(l.left, r.right) && filter(l.right, r.left);
        // 先判断左的左+右的右, 再判断左的右和右的左, 即为镜像
    }

}
