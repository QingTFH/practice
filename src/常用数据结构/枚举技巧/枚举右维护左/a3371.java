package 常用数据结构.枚举技巧.枚举右维护左;

import java.util.HashMap;

public class a3371 {

    // 有两个值不计入sum;
    // 任取两个数a, b减掉, 剩下的值等于a, 此时a = 和, b = 异常值
    // 统计数组的sum, 对于nums[i], 他要成为异常值b, 就需要找到2 * a == sum - b

    public int getLargestOutlier(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>(); // 元素值 -> 频率

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.merge(nums[i], 1, Integer::sum);
        }

        for(int i = 0; i < nums.length; i++) {
            if(((sum - nums[i]) % 2 == 0) ){
                // 存在 2 * a == sum - b, 此时nums[i]可以成为异常值b
                // 但必须判断a 和 b的下标不同 -> a == b时 nums[i]的频率 > 2
                int a = (sum - nums[i]) / 2;
                if(map.containsKey(a)
                        && !(a == nums[i] && map.get(nums[i]) == 1)) {
                    // 存在a 且 a,nums[i]下标不同
                    result = Math.max(result, nums[i]);
                }
            }
        }
        return result;
    }


}
