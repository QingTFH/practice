package 单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class a402 {

    // 保证高位的数字尽可能小，让低位的更小数字上浮，因此使用单调递增栈;

    public String removeKdigits(String num, int k) {

        if(k >= num.length()) {
            return "0";
        }

        int left = k; // 剩余删除次数
        int i = 0; // 遍历到的位置
        Deque<Character> stack = new ArrayDeque<>();
        for(; i < num.length() && left > 0; i++) {
            while(!stack.isEmpty() && num.charAt(i) < stack.peek() && left > 0) {
                left--;
                stack.pop();
            }
            stack.push(num.charAt(i));
        }

        // 遍历结束后，如果left仍有剩余，需要从栈顶继续删除元素
        while(left > 0) {
            left --;
            stack.pop();
        }

        // 出栈，倒序，拼接
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        for(; i<num.length(); i++) {
            sb.append(num.charAt(i));
        }

        // 去除前导0
        while(!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }

}
