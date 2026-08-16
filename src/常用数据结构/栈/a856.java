package 常用数据结构.栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class a856 {

    // 遇到右括号时统计括号内的分数 = 分数之和 * 2

    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(0); // 占位
            } else {
                int i = stack.pop();
                if(i == 0) { // "()"
                    stack.push(1);
                } else { // "(....)"
                    while(stack.peek() != 0) {
                        i += stack.pop();
                    }
                    stack.pop(); // 弹出0
                    stack.push(i * 2);
                }
            }
        }

        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

}
