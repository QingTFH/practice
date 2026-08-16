package 常用数据结构.栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class a2696 {

    public int minLength(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for(char c : s.toCharArray()) {
            if(top >= 0
                    && ((c == 'B' && stack[top] == 'A') || (c == 'D' && stack[top] == 'C'))) {
                top--;
            } else {
                stack[++top] = c;
            }
        }


        return top + 1;
    }

}
