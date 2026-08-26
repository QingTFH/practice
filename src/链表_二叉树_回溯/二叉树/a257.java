package 链表_二叉树_回溯.二叉树;

import java.util.ArrayList;
import java.util.List;

public class a257 {

    // 对于node, 它会是: null, leaf, nonleaf
    // 如果是null, 无视; 如果是leaf, 传入当前path; 如果是nonLeaf, 继续递归
    // 使用StringBuilder会传入指针, 不行, 只能使用不可变量; 不过String的add操作复杂度相对高不少

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return result;
    }

    private void dfs(TreeNode node, String path) {
        if (node == null) // null
            return;

        if (node.left == null && node.right == null) { // leaf
            path += node.val;
            result.add(path);
            return;
        }

        path += node.val + "->"; // nonleaf
        dfs(node.left, path);
        dfs(node.right, path);
    }

}
