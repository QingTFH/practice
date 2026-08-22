package 链表_二叉树_回溯.链表;

public class a141 {

    // 快慢指针判定成环: 如果有环, 快指针无法停下, 由于速度更快，一定会再次遇到慢指针
    // 循环次数: 假设链表size = n, 当slow走了n步后, fast恰好走了2 * n步, 恰好和slow相遇, 循环次数为n, 时间O(n)

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            // 先走再判定, 避免初始化的问题
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow)
                return true;
        }

        return false;
    }

}
