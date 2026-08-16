package 常用数据结构.栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class a946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int pos = 0;
        for (int i : pushed) {
            stack.push(i);
            while(!stack.isEmpty() && stack.peek() == popped[pos]) {
                stack.pop();
                pos++;
            }
        }
        return pos == popped.length;
    }

}
