package 链表_二叉树_回溯.二叉树;

import java.util.ArrayList;
import java.util.List;

public class a144 {

    // 前序遍历二叉树, 将元素值加入到List中
    // 如果要有递归返回值, 那就需要在每次dfs中都创建list, 然后addAll, 再返回, 边界条件会是空

    // x序遍历 = 将"自身""x"处理, 比如前序遍历就是中左右, 中序就是左中右, 后续就是左右中

    public List<Integer> preorderTraversal(TreeNode root) {
        return dfs2(root);
    }

    private void dfs_left(TreeNode node, List<Integer> list) {
        // 归, 如果节点是空的, 直接跳过
        if (node == null) return;

        // 递
        list.add(node.val);
        dfs_left(node.left, list);
        dfs_left(node.right, list);
    }

    private List<Integer> dfs2(TreeNode node) {
        // 归, 如果节点是空的, 返回空
        if (node == null) return new ArrayList<>(); // 如果是null会抛异常

        // 递
        List<Integer> result = new ArrayList<>();
        result.add(node.val);
        result.addAll(dfs2(node.left));
        result.addAll(dfs2(node.right));

        return result;
    }

}
