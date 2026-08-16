package 常用数据结构.前缀和;

public class a3427 {

    // 对于每个下标i, start = max(i - nums[i], 0), 需要知道nums[start, i]的和

    public int subarraySum(int[] nums) {

        int[] suffix_sum = new int[nums.length + 1];
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            suffix_sum[i+1] = suffix_sum[i] + nums[i];
            int start = Math.max(0, i - nums[i]);
            result += suffix_sum[i+1] - suffix_sum[start];
        }

        return result;
    }

}
