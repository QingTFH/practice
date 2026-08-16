package 常用数据结构.枚举技巧.枚举右维护左;

import java.util.HashMap;

public class a3761 {

    public int minMirrorPairDistance(int[] nums) {
        int result = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>(); // reverse(nums[i]) -> i

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                result = Math.min(Math.abs(map.get(nums[i]) - i), result) ;
            }

            int t = reverse(nums[i]);
            map.put(t, i);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

}
