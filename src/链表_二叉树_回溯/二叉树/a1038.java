package 链表_二叉树_回溯.二叉树;

public class a1038 {

    // BST: 左小右大; 要求将每个node.val替换成"大于等于node.val的所有节点"的val和
    // 大于等于的节点一定在node的右子树或者node父亲的右子树中, 也就是替换成"右子树 + 自身"的和;

    // 自底向上操作, 先处理右子树, 再将自身值 += node.right.val, 再处理更小的左子树
    // 问题在于递归右子树right的时候, 右子树right的左子树right.left不会被加入右子树的根值right.val中,
    // 处理根node.val的时候会被忽略掉;

    // 需要外部变量 = ">=当前节点的值"的和, 也就是"右子树 - 根 - 左子树"的顺序遍历

    int s = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null)
            return null;

        bstToGst(root.right);

        s += root.val;
        root.val = s;

        bstToGst(root.left);

        return root;
    }

}
