package 常用数据结构.前缀和;

import java.util.HashMap;

public class a2588 {

    // 美丽数组：每一位上都有偶数个1 -> 异或的结果为0

    public long beautifulSubarrays(int[] nums) {
        int[] prefix_xor = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix_xor[i+1] = prefix_xor[i] ^ nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result + map.getOrDefault(prefix_xor[i+1], 0)
                    + (prefix_xor[i+1] == 0 ? 1 : 0);
            map.merge(prefix_xor[i+1], 1, Integer::sum);
        }

        return result;
    }

}
