package 常用数据结构.枚举技巧.枚举右维护左;

import java.util.HashMap;

public class a2815 {

    // 从 nums 中找出"和最大"的一对数，
    // 且这两个数"数位上最大的数字"相等。(比如71和27,最大的数字是7)
    // 返回最大和，如果不存在满足题意的数字对，返回 -1 。

    // 数位上最大的数字只能是0 ~ 9, 和最大的情况就是nums[i] + max[数位最大的位置]

    public int maxSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // 数位上最大的数 -> 元素
        int ans = -1;
        for(int i = 0; i < nums.length; i++) {
            // 1. 获取nums[i] "数位上最大的数"
            int temp = nums[i];
            int max = 0;
            while(temp > 0) {
                max = Math.max(max, temp % 10);
                temp /= 10;
            }

            // 2. 尝试求和
            int ori = map.getOrDefault(max, 0); // map中原来的值
            if(ori != 0) {
                ans = Math.max(ans, ori + nums[i]);
            }

            // 3. 更新map中的最大值
            if(nums[i] > ori) {
                map.put(max, nums[i]);
            }

        }
        return ans;
    }

}
