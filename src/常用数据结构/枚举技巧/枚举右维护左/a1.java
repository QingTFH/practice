package 常用数据结构.枚举技巧.枚举右维护左;

import java.util.HashMap;

public class a1 {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(); // 元素 -> 索引
        for (int i = 0; i < nums.length; i++) {
            // 对于nums[i]，他需要的元素是target = nums[i]，直接查找hashmap即可;
            if(map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }

}
