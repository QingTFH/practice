package 单调栈;

import java.util.ArrayList;
import java.util.List;

public class a1019<ListNode> {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public int[] nextLargerNodes(ListNode head) {

        // 1. 将链表转为 ArrayList，实现按索引取值
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int n = values.size();
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // 存储下标

        // 2. 完全复用单调栈逻辑
        for (int i = 0; i < n; i++) {
            int currentVal = values.get(i);
            // 当前值比栈顶下标对应的值大，说明找到了“下一个更大”
            while (!stack.isEmpty() && currentVal > values.get(stack.peek())) {
                int prevIndex = stack.pop();
                answer[prevIndex] = currentVal; // 存入值，而非天数
            }
            stack.push(i);
        }
        // 栈中剩余下标对应的 answer 默认为 0，无需额外操作
        return answer;

    }

}
