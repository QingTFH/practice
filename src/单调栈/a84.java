package 单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class a84 {

    /*
     * 思路：
     * 从枚举高的角度
     *      （对于数组元素nums[i]，我们以其高度h为标准，向左右两侧延申，直到遇到高度小于h为止，
     *      此时左边界x，右边界y，矩形底长度w = y-x+1，面积为h * w）
     * 来讲，我们可以”预先延申“：提前找到i左右两侧的“第一个小于nums[i]”的位置，就提前确定了w；
     * 这可以使用两次单调栈来进行；
     */


    public int largestRectangleArea(int[] heights) {
        // 1. 找到左侧第一个更小值(不存在则是-1); (开区间)
        int[] left = findLeftFirstSmaller(heights, -1);
        System.out.println(Arrays.toString(left));

        // 2. 找到右侧第一个更小值(不存在则是n);
        int[] right = findRightFirstSmaller(heights, heights.length);
        System.out.println(Arrays.toString(right));

        // 3. 寻找w * nums[i]的最大值 w = right[i] - left[i] - 1 (比如右侧第一个和左侧第一个,那就是(i+1) - (i-1) - 1 = 1)
        int max = 0;
        for(int i = 0; i < heights.length; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
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
