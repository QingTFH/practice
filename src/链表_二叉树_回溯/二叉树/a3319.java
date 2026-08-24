package 链表_二叉树_回溯.二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class a3319 {

    // 判断一个节点是不是完美二叉树的根节点, 记录它的大小(自底向上)
    // 需要知道:
    // 1. 左右两棵子树是不是完美二叉树; -> 可以使用非法值来判断
    // 2. 左右两棵子树的叶子深度;
    // 3. 左右两棵子树的大小

    // 查询题解后发现, 如果一颗树是完美二叉树(满二叉树), 则大小确定为2 ^ h - 1(h是高度), 则3不需要记录;
    // 因此只需要知道"左右两棵子树的叶子深度"/子树高度, 前者需要多维护当前节点的高度, 更麻烦

    List<Integer> list = new ArrayList<>();

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        dfs(root);

        if (list.size() < k)
            return -1;

        list.sort(Comparator.reverseOrder()); // 降序排列
        return (1 << (list.get(k - 1))) - 1; // 2 ^ k == 1 << k
    }

    private int dfs(TreeNode node) {
        // 返回值为当前子树高度, 如果非法则-1
        if (node == null)
            return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);

        if (l == -1 || l != r)
            return -1;

        list.add(l + 1);
        return l + 1;
    }

}
