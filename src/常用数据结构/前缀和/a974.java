package 常用数据结构.前缀和;

import java.util.HashMap;

public class a974 {

    // 考虑连续子数组的和 -> 前缀和

    public int subarraysDivByK(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i+1] = ((prefix[i] + nums[i]) % k + k) % k;
        }

        int result = 0;
        int[] map = new int[k];
        for (int i = 0; i < nums.length; i++) {
            // 对于总和 mod k为prefix[i+1]的数组, 它想要mod k = 0, 需要减去什么呢?
            result += (prefix[i+1] == 0 ? 1 : 0) + (map[prefix[i+1]]++);
        }
        return result;
    }

}
