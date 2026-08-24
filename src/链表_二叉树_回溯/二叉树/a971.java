package 链表_二叉树_回溯.二叉树;

import java.util.ArrayList;
import java.util.List;

public class a971 {

    // 进入节点node时, 尝试匹配val = num[i], left.val = num[i + 1]
    // 如果val匹配不上, 返回false; 如果left匹配不上, 交换左右两侧的节点(先进入右边的子节点即可, 不必进行实际交换)
    // 如果依然不可行则不成立
    // 需要传入当前位置的索引? -> 难以通过返回值等方式操作index, 可以设立成公共变量

    int index = 0; // 当前节点应当有的匹配值
    int[] voyage;
    List<Integer> result = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        if (!dfs(root)) {
            List<Integer> r2 = new ArrayList<>();
            r2.add(-1);
            return r2;
        }
        return result;
    }

    private boolean dfs(TreeNode node) {
        if (node.val != voyage[index ++]) // 这一条是"翻转后"的判断, 也就是当left不可行时先进入right并判断right是否可行
            return false;

        if (node.left == null && node.right == null)
            return true;

        if (node.left == null)
            return dfs(node.right); // 无法进行交换

        if (node.right == null)
            return dfs(node.left); // 无法进行交换

        // 可以进行交换的前提下, 如果left不是voyage的下一个元素, 那就先尝试匹配right
        if (node.left.val != voyage[index]) {
            result.add(node.val);
            return dfs(node.right) & dfs(node.left); // 只要有一个不可行, 那就全部不可行
        }

        return dfs(node.left) & dfs(node.right);
    }

}
