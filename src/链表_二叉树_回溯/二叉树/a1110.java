package 链表_二叉树_回溯.二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a1110 {

    // 自底向上操作;
    // 先更新一个点的左右孩子, 再判断是否要删除它
    // 删除一个点时, 将它的非空孩子放入List, 返回null

    List<TreeNode> result = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Arrays.stream(to_delete).forEach(set::add);
        TreeNode r = dfs(root);
        if (r != null)
            result.add(r);
        return result;
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null)
            return null;

        root.left = dfs(root.left);
        root.right = dfs(root.right);

        if (!set.contains(root.val)) {
            return root;
        }

        if (root.left != null)
            result.add(root.left);
        if (root.right != null)
            result.add(root.right);
        return null;
    }

}
