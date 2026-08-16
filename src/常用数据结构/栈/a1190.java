package 常用数据结构.栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class a1190 {

    // 逐个将字符压入栈中;
    // 当遇到")"时, 逐个弹出字符并拼接, 直到遇到"(", 将拼接后的字符放回

    // 逐个将字符压入栈 --优化成--> 将括号之间的字符记录成字符串

    public String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == '(') { // c是左括号 -> sb放入栈中, 重置sb
                stack.push(sb); // 空串可以占位
                sb = new StringBuilder();
            } else if (c == ')') { // c是右括号 -> 反转sb并接入栈顶字符串后
                sb.reverse();
                sb = stack.pop().append(sb);
            } else { // c不是括号 -> 拼接
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
