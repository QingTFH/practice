package 单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class a1793 {

    /*
     * 题目：返回整数数组nums中, "好子数组"的最大"分数"(给定k)
     * 子数组(左右边界i, j,闭区间)的分数 = min(nums[i],nums[i+1]....nums[j]) * (j - i + 1)
     * 好子数组：i <= k <= j
     */

    /*
     * 思路：
     * 子数组的分数只与数组中的最小值有关，所以可以遍历每个nums[i]并将其认定为该数组中的最小值，
     * 向左右延展直到有更小的元素(不计入数组区间)，此时数组分数直接为nums[i] * 数组宽度(r-l+1)；
     * 这可以用单调栈来实现O(1)时间复杂度地查询"左右两端更小元素的索引"；（O(n)时间复杂度的预处理）
     *
     * 在此基础上，需要保证这个是“好”子数组，也就是l <= k <= r
     */

    public int maximumScore(int[] nums, int k) {
        // 1. 找到左右两侧的更小值
        int[] left = findLeftFirstSmaller(nums, -1);
        int[] right = findRightFirstSmaller(nums, nums.length);

        // 2. 计算好子数组可能的最大分数
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            int l = left[i] + 1;
            int r = right[i] - 1; // 数组元素表示"更小的值"，不应在子数组范围内
            if(l <= k && k <= r) {
                max = Math.max(max, (r-l+1) * nums[i]);
            }
        }

        return max;
    }

    public int[] initialNums(int length, int initial) {
        int[] ans = new int[length];
        Arrays.fill(ans, initial);
        return ans;
    }

    public int[] findLeftFirstSmaller(int[] nums, int initial) {
        int[] ans = initialNums(nums.length, initial);
        Deque<Integer> stack = new ArrayDeque<>(); // 存储下标
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) { // 尝试出栈
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] findRightFirstSmaller(int[] nums, int initial) {
        int[] ans = initialNums(nums.length, initial);
        Deque<Integer> stack = new ArrayDeque<>(); // 存储下标
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) { // 尝试出栈
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        return ans;
    }

}
