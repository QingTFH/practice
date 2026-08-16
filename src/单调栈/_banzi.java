package 单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _banzi {

    public int[] initialNums(int length, int initial) {
        int[] ans = new int[length];
        Arrays.fill(ans, initial);
        return ans;
    }

    public int[] findLeftFirstBigger(int[] nums) {
        int[] ans = initialNums(nums.length, -1);
        Deque<Integer> stack = new ArrayDeque<>(); // 存储下标
        for (int i = nums.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) { // 尝试出栈
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] findRightFirstBigger(int[] nums) {
        int[] ans = initialNums(nums.length, -1);
        Deque<Integer> stack = new ArrayDeque<>(); // 存储下标
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) { // 尝试出栈
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
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

    public int[] findRightFirstSmaller(int[] nums, int initial) {
        int[] ans = initialNums(nums.length, initial);
        Deque<Integer> stack = new ArrayDeque<>(); // 存储下标
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) { // 尝试出栈
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        return ans;
    }


}
