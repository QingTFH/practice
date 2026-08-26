package 链表_二叉树_回溯.二叉树;


import java.util.ArrayList;
import java.util.List;

public class a113 {

    // 类似113, 区别1: 只记录长度为目标长度的path; 区别2: 用外部List更好解决
    // 使用外部List时, 由于记录的是过程量, 在归之前需要清理掉冗余量(自己操作所导致的数据)
    // 例如: 访问节点node, 会先调用path.add(node); 当node操作结束后, 需要path.remove(node); 记录索引应该更好

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    int target;
    int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;

        int index = path.size(); // 本次加// 入会放到第几个索引
        path.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null && sum == target) {
            result.add(new ArrayList<>(path));
        } else {
            dfs(node.left);
            dfs(node.right);
        }

        path.remove(index);
        sum -= node.val;
    }

}
