package 单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class a907 {

    // 需要保证[1,2,3,3]这种数组中，以3为最小值的子数组只有3个，而非被计入4次

    long MAGIC = (long) (1e9+7);

    public int sumSubarrayMins(int[] arr) {
        // 1. 找到以nums[i]为最小值的边界
        int[] left = findLeftFirstSmaller(arr, -1);
        int[] right = findRightFirstEqualSmaller(arr, arr.length);

        // 2. 计算nums[i]的贡献
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int l = left[i] + 1;
            int r = right[i] - 1;
            // 贡献量为 nums[i] * 以nums[i]为最小值的数组个数, 也就是[l,r]中 l<=i<=r的数组个数
            // l有l, l+1, ..... i种 也就是 i-l+1种选择; r同理
            long cnt = (long) (i - l + 1) * (r-i+1);
            ans = (ans + arr[i] * cnt) % MAGIC;
        }

        return Math.toIntExact(ans);
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
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) { // 尝试出栈
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] findRightFirstEqualSmaller(int[] nums, int initial) {
        // 左侧严格小于，右侧小于等于，保证不重复
        int[] ans = initialNums(nums.length, initial);
        Deque<Integer> stack = new ArrayDeque<>(); // 存储下标
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) { // 尝试出栈
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        return ans;
    }


}

