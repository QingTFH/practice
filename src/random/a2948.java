package random;

public class a2948 {

    // |nums[i] - nums[j]| <= limit时, 可以交换i, j -> 一个nums[i]可以交换的nums[j]是固定的
    // 要求让字典序最小 -> 让每个nums[i]到它所能到达的最小的位置
    // |nums[i] - nums[j]| <= limit && i < j && nums[j] > nums[i], 交换i, j

    // 看题解得知：假如i可以和j换, 但是不能和k换, 但是j能和k换 -> 任何i与k换的操作可以通过j作为桥梁完成, 可以认为i可以和k换
    // 因此, 这特么是类似置换环的题目: "可以交换的位置"为一个连通块, 将每个连通块中的元素按字典序排即可, 使用并查集...吗, 感觉会很慢

    // 先跳过吧

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        return null;
    }

}
