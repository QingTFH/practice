package 单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class a503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n]; // 默认值-1
        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>(); // 存储下标

        for (int i = 0; i < 2*n; i++) { // 遍历两次 0 ~ n-1, 一共2*n次
            // 数组元素下标是 i % n;
            while (!stack.isEmpty() && nums[i%n] > nums[stack.peek()]) {
                int x = stack.pop(); // 出栈并更新ans
                answer[x] = nums[i % n];
            }
            stack.push(i % n);
        }

        return answer;
    }

}
