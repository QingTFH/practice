package 链表_二叉树_回溯.链表;

public class a2130 {

    // 类似234, 先找到后中点middle, 反转后半, 两端同时遍历直到tail端经过middle

    public int pairSum(ListNode head) {
        // 1. 找到middle
        ListNode middle = findMiddle(head);

        // 2. 反转后半段
        ListNode tail = reverse(middle, null);

        // 3. 两端遍历
        int max = 0;
        while (tail != null) { // 跳出时, tail应当经过了middle
            max = Math.max(head.val + tail.val, max);
            tail = tail.next;
            head = head.next;
        }

        return max;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        // 反转从head开始的链表, 新链表的尾巴是tail, 返回新的head
        ListNode cur = head, pre = tail;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode findMiddle(ListNode head) {
        // 返回后中点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
