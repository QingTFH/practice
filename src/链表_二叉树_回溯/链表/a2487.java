package 链表_二叉树_回溯.链表;

import java.util.ArrayDeque;
import java.util.Deque;

public class a2487 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 类似于单调栈, 不过存入的是每个节点, 最后再串起来
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            while (!stack.isEmpty() && stack.peek().val < head.val) {
                stack.pop();
            }
            stack.push(head);
            head = head.next;
        }

        ListNode result = null;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (result == null) {
                result = node;
            } else {
                node.next = result;
                result = node;
            }
        }
        return result;
    }

}
