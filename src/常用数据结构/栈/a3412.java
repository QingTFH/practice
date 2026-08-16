package 常用数据结构.栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class a3412 {

    public long calculateScore(String s) {
        Deque<Integer>[] stk = new ArrayDeque[26];
        Arrays.setAll(stk, i -> new ArrayDeque<>());
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (!stk[25 - c].isEmpty()) {
                ans += i - stk[25 - c].pop();
            } else {
                stk[c].push(i);
            }
        }
        return ans;
    }

}
