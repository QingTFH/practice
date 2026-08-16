package 常用数据结构.枚举技巧.枚举右维护左;

public class a3917 {

    // 需要找到nums[i]右侧具有不同奇偶性的元素个数

    // 思路一: 预统计后缀的奇数个数和偶数个数(不包括nums[i])
    // 思路二: 枚举技巧, 从后往前遍历, 数组维护"nums[i] % 2 -> 个数"

    public int[] countOppositeParity(int[] nums) {
        int[] result = new int[nums.length];
        int[] map = {0, 0}; // nums[i] % 2 的个数,也就是偶数的个数在map[0]
        for (int i = nums.length - 1; i >= 0; i--) {
            int t = nums[i] % 2;
            result[i] = map[1 - t];
            map[t] ++;
        }

        return result;
    }


}
