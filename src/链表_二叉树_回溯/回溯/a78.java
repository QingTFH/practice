package 链表_二叉树_回溯.回溯;

import java.util.ArrayList;
import java.util.List;

public class a78 {

    // 解法1: 对于nums[i], 它"选"和"不选"会划分出两种结果
    // 解法2: 每次选择一个数; 为避免重复, 需要拟定"下一次选择的数"的要求

    // 问题: 从当前nums中获取子集
    // 操作: 剥离一个数nums[i], 获得子集nums - nums[i] (或者是向当前集合中添加一个nums[i], 获得子集nums[i*])
    // 下一个问题: 从nums - nums[i]中获取子集          (或者是向当前集合中添加一个nums[j], 获得子集; 注意i != j并且[i, j]和[j, i]是同个集合)

    // 等价于: 选/不选nums[i]

    ArrayList<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs2(0);
        return result;
    }

    private void dfs(int index) {
        // index位置的数字选/不选, 进行分支
        if (index == nums.length) {    // 所有元素都操作完了
            result.add((List<Integer>) path.clone());
            return;
        }

        dfs(index + 1); // 不选index

        path.add(nums[index]);    // 选index
        dfs(index + 1);
        path.remove((Object)nums[index]);   // 注意要obj, 不然默认是path中的索引
    }

    private void dfs2(int index) {
        // 每次选择一个数加入path中, 如果还有可以加入的元素, 继续操作path
        // 为避免{n[1], n[2]}和{n[2], n[1]}的重复情况, 规定只有大于等于index的元素才可加入
        result.add((List<Integer>) path.clone());   // 每一个情况都是答案

        if (index == nums.length) { // 没有可以加入的元素了
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs2(i + 1);
            path.remove((Object) nums[i]);
        }

    }

}
