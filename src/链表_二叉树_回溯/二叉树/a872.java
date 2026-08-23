package 链表_二叉树_回溯.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class a872 {



    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        System.out.println(getLeaf(root1));
        System.out.println(getLeaf(root2));
        return equal(getLeaf(root1), getLeaf(root2));
    }

    private List<Integer> getLeaf(TreeNode node) {
        // 获得这一块子树的叶节点
        if (node == null)
            return new ArrayList<>();

        if (node.left == null && node.right == null) {
            List<Integer> result = new ArrayList<>();
            result.add(node.val);
            return result;
            // 注意：new ArrayList<>(node.val)不是初始化自带元素val, 而是list的容量预先设置为val
            // 这个方法的作用是避免容量不足时, 反复内存扩容(内存操作), 导致性能浪费
        }


        // 不是叶子节点
        List<Integer> result = new ArrayList<>();
        result.addAll(getLeaf(node.left));
        result.addAll(getLeaf(node.right));

        return result;
    }

    private boolean equal(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size())
            return false;

        int n = a.size();
        for (int i = 0; i < n; i++) {
            if (!Objects.equals(a.get(i), b.get(i)))
                return false;
        }

        return true;
    }

}
