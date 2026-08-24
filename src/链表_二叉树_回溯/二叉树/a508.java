package 链表_二叉树_回溯.二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class a508 {

    // 创建HashMap: 和 -> 次数; 结束后找到次数最大值并捕获它们

    // 子树的和: 左子树的和 + 右子树的和 + 自己

    // 这样写没啥难度, 但是要频繁过滤+转换数据结构, 学习使用stream

    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int max = map.values().stream().max(Integer::compareTo).orElse(0);
        List<Integer> result = map.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey) // 映射: 将entry映射成getkey操作后的类型
                .collect(Collectors.toList());

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int result = dfs(node.left) + dfs(node.right) + node.val;
        map.merge(result, 1, Integer::sum);
        return result;
    }

}
