package 常用数据结构.枚举技巧.枚举右维护左;

public class a2874 {

    // nums[i] > 0 --> (nums[i] - nums[j]) * nums[k] 的符号由(nums[i] - nums[j])决定
    // 对于每个nums[j], 它的最大三元组需要让nums[i]和nums[k]都尽可能大,
    // 并且并不在意i和k的具体索引, 也并不一定要大于nums[j]
    // 因此使用前后缀最大值而非单调栈

    public long maximumTripletValue(int[] nums) {
        int[] prefix_max = new int[nums.length];
        int[] suffix_max = new int[nums.length];

        for(int i = 0, max = 0; i < nums.length; i++) {
            prefix_max[i] = max;
            max = Math.max(max, nums[i]); // prefix不能包含 nums[i]
        }

        for (int i = nums.length - 1, max = 0; i >= 0 ; i--) {
            suffix_max[i] = max;
            max = Math.max(max, nums[i]);
        }

        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, (long) (prefix_max[i] - nums[i]) * suffix_max[i]);
        }

        return result;
    }

}
