package random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class a3471 {

    // 寻找数组中最大的"仅出现在长度为k的子数组中一次"的数字;
    // 由于窗口从[0~k-1]开始向[n-k,n-1]移动, 如果k不为1, 那除了两端的数字之外, 其余数字都至少出现两次, 一定不符合题意;
    // 若k = length, 退化为"寻找数组中的最大值", 因为所有数字都只出现在一个子数组中, 不等同于k == 1

    public int largestInteger(int[] nums, int k) {
        if(k == nums.length) {
            int max = -1;
            for (int n : nums) max = Math.max(max, n);
            return max;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.merge(n, 1, Integer::sum);
        }

        int result = -1;

        if (k > 1) { // 两端中只出现过一次的较大值
            if(map.get(nums[0]) == 1) result = Math.max(nums[0], result);
            if(map.get(nums[nums.length - 1]) == 1) result = Math.max(nums[nums.length - 1], result);
        } else { // 数组中只出现过一次的最大值
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() == 1) {
                    result = Math.max(result, entry.getKey());
                }
            }
        }

        return result;
    }

}
