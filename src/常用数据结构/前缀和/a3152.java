package 常用数据结构.前缀和;

public class a3152 {

    // 对于子数组中每一个元素,我们需要知道它相邻的元素是否和他奇偶性相同,如果存在这样的元素, 那么子数组就不是目标数组;
    // 如何判断每一个元素: 只判断后一个元素是否和他相同, 在最后处理[l, r]时只看[l, r-1]的部分
    // 如何判断整个数组: 假设"某个元素不与相邻的元素奇偶性相同"记为0, 只需要判断区间内的和是否为0即可

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefix_cnt = new int[nums.length + 1];
        for (int i = 0; i <= nums.length - 2; i++) {
            prefix_cnt[i+1] = (nums[i] % 2 == nums[i+1] % 2 ? 1 : 0) + prefix_cnt[i];
        }
        prefix_cnt[nums.length] = prefix_cnt[nums.length - 1];

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = prefix_cnt[r] - prefix_cnt[l] == 0; // 只考虑[l, r)内的元素
        }
        return result;
    }

}
