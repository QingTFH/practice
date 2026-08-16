package 单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class a739 {

    // 单调栈

    /*  思路
     *  使用一个栈记录元素；
     *  从左到右遍历数组，对于元素a[i]，如果栈顶元素x比它更小，说明a[i]是x的“下一个更高温度”，弹出x，更新ans数组；
     *  直到x >= a[i]，将a[i]压入栈内；
     *  遍历结束后，将没有数据的ans[j]置0; (默认为0)
     */

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // 存储下标

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 当前温度比栈顶下标对应温度高，说明找到了“下一个更高温度”
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex; // 计算天数差
            }
            stack.push(i); // 当前下标入栈，等待后续更高温度
        }

        return answer; // 未更新的位置默认为0
    }

}
