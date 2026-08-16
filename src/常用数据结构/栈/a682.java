package 常用数据结构.栈;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class a682 {

    public int calPoints(String[] operations) {
        int[] stack = new int[1007];
        int pos = 0;
        for(String s : operations) {
            if (s.equals("D")) {
                stack[pos] = stack[pos - 1] * 2;
                pos ++;
            } else if(s.equals("C")) {
                pos--;
            } else if(s.equals("+")) {
                stack[pos] = stack[pos - 1] + stack[pos - 2];
                pos ++;
            } else {
                stack[pos++] = Integer.parseInt(s);
            }
        }

        int result = 0;
        for (int i = 0; i < pos; i++) {
            result += stack[i];
        }
        return result;
    }

}
