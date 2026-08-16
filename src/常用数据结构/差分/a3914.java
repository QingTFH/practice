package 常用数据结构.差分;

public class a3914 {

    // 粗浅的认为：对于nums[i], 如果后续[i+1, r]比nums[i]小, 则都加上nums[i] - nums[i + 1]
    // 但是操作[i+1, r]和操作[i+1, n-1]的代价相同, 而后者可以保证原本后面更大的值不会反过来更小；

    public long minOperations(int[] nums) {
        int[] diff = new int[nums.length - 1];
        // 只需要获得差分值, 不需要再次求和
        // diff[i] = nums[i+1] - nums[i]
        for (int i = 0; i < nums.length - 1; i++) {
            diff[i] = nums[i+1] - nums[i];
        }

        // 对于后一个元素比前一个元素小的情况, 后续所有元素都要加上差值, 也不会改变后续的相对差值
        long result = 0;
        for (int i = 0; i < diff.length; i++) {
            if(diff[i] < 0) {
                result += (-diff[i]);
            }
        }

        return result;
    }

}
