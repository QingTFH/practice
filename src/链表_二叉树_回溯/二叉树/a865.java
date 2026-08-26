package 链表_二叉树_回溯.二叉树;

public class a865 {

    // 多子版本的LCA, 本质没差别, 只是要考虑最深的叶子

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return (TreeNode) dfs(root)[1];
    }

    private Object[] dfs(TreeNode root) {
        if (root == null)
            return new Object[]{0, null}; // 深度 + 当前祖先

        if (root.left == null && root.right == null)
            return new Object[]{1, root};

        Object[] l = dfs(root.left);
        Object[] r = dfs(root.right);
        if ((int)l[0] == (int)r[0]) { // 深度相同, 更新祖先为自己
            return new Object[]{(int)l[0] + 1, root};
        }

        Object[] ans = (int)l[0] > (int)r[0] ? l : r; // 以更深的那个作为答案
        ans[0] = (int)ans[0] + 1;
        return ans;
    }

}
