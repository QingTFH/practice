package 常用数据结构.枚举技巧.枚举中间;

import java.util.HashMap;

public class a3583 {

    // nums[i] = nums[j] * 2 && nums[k] == nums[i]
    // 想知道nums[i]左侧有多少个元素x,可以使用hashmap维护, 当遍历到i时自然知道左侧有多少x, 而不是预处理
    // 想知道nums[i]右侧有多少元素x, 只要知道一共有多少个元素x, 减去左侧即可

    // 0 <= nums[i] <= 1e5;

    private final static int MOD = (int) (1e9 + 7);

    public int specialTriplets(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>(); // 元素值 -> 总频率
        for (int i = 0; i < nums.length; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
        }

        HashMap<Integer, Integer> leftCnt = new HashMap<>(); // 元素值 -> 当前频率

        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            long left = leftCnt.getOrDefault(nums[i] * 2, 0);
            leftCnt.merge(nums[i], 1, Integer::sum); // 在此更新leftCnt,
            // 可以一并处理nums[i] = 0时, right = cnt - left - 1的逻辑
            long right = cnt.getOrDefault(nums[i] * 2, 0)
                    - leftCnt.getOrDefault(nums[i] * 2, 0);
            result = (result + ((left % MOD) * (right % MOD)) % MOD) % MOD;
        }

        return Math.toIntExact(result);
    }

}
