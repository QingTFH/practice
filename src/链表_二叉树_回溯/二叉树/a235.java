package 链表_二叉树_回溯.二叉树;

public class a235 {

    // 找到p和q的最近公共祖先, 也就是第一个将p,q汇流的节点node -> p,q分别位于左/右子树, 或者node本身
    // 没有用到“二叉搜索树”的性质, 因此这份代码其实算是236的答案(普通二叉树的LCA)

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        // 左右两侧的搜索状况
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        // l, r, node, 三者如果有两个满足条件, 那么node就是答案;
        // 如果只有一个满足条件, 需要继续向上追溯;
        // 如果都没有, 说明不在这一侧, 同null

        boolean t = root == p || root == q; // node是答案吗

        if (l == null && r == null && !t)
            return null;

        if (l == null && r == null)
            return root;

        if (l == null && !t)
            return r;

        if (r == null && !t)
            return l;

        return root;
    }

}
