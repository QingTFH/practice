package 常用数据结构.枚举技巧.枚举右维护左;

import java.util.HashMap;

public class a2441 {

    public int findMaxK(int[] nums) {
        int max = -1;
        HashMap<Integer, Integer> map = new HashMap<>(); // 元素 -> 索引
        for (int i = 0; i < nums.length; i++) {
            // 对于nums[i]，他需要的元素是-nums[i]，直接查找hashmap即可;
            if(map.containsKey(-nums[i])) {
                max = Math.max(Math.abs(nums[i]), max);
            }
            map.put(nums[i], i);
        }

        return max;
    }

}
