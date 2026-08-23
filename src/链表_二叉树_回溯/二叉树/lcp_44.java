package 链表_二叉树_回溯.二叉树;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lcp_44 {

    // 使用set的遍历, 这样简洁但是创建set开销大, 内存和耗时都更大

    public int numColor(TreeNode root) {
        return dfs(root).size();
    }

    private Set<Integer> dfs(TreeNode node) {
        // 归, 如果节点是空的, 返回空
        if (node == null) return new HashSet<>(); // 如果是null会抛异常

        // 递
        Set<Integer> result = new HashSet<>();
        result.add(node.val);
        result.addAll(dfs(node.left));
        result.addAll(dfs(node.right));

        return result;
    }

}
