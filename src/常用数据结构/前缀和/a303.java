package 常用数据结构.前缀和;

public class a303 {

    class NumArray {

        int[] sum; // 前缀和, sum[i] = 前i-1个元素的和, sum[0] = 0

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i+1] = sum[i] + nums[i];
            }

        }

        public int sumRange(int left, int right) {
            // 返回nums[left] + nums[left + 1] + ... + nums[right]
            return sum[right + 1] - sum[left];
        }
    }

}
