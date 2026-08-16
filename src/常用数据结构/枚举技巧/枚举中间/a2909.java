package 常用数据结构.枚举技巧.枚举中间;

public class a2909 {

    // 找出nums[i]中元素和最小的山形三元组

    // 山形三元组: i < j < k, 有nums[j] > nums[i] 且 nums[j] > nums[k]
    // 山形三元组的元素和nums[i] + nums[j] + nums[k];

    // 只需找到j左侧最小的元素和右侧最小的元素(不考虑具体索引和与nums[j]的大小关系)
    // 判断是否满足山形三元组的要求即可(如果不满足, 那也不存在以该索引为j的组合)

    // nums[i] > 0

    public int minimumSum(int[] nums) {
        int[] prefix_min = new int[nums.length];
        for (int i = 0, min = Integer.MAX_VALUE; i < nums.length; i++) {
            prefix_min[i] = min;
            min = Math.min(min, nums[i]); // prefix[i]不能包含nums[i]
        }

        int[] suffix_min = new int[nums.length];
        for (int i = nums.length - 1, min = Integer.MAX_VALUE;
             i >= 0; i--) {
            suffix_min[i] = min;
            min = Math.min(min, nums[i]);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(prefix_min[i] < nums[i] && suffix_min[i] < nums[i]) {
                result = Math.min(result, prefix_min[i] + nums[i] + suffix_min[i]);
            }
        }


        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
