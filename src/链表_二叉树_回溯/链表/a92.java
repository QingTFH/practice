package 链表_二叉树_回溯.链表;

public class a92 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 反转第left ~ right个节点之间的节点
    // 先找到left和left.pre; 头插法获得翻转后的r ~ l; 将left.pre.next = r, l.next = right.next
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int cnt = 1;
        ListNode cur = head, h = null;
        while (cnt < left) {
            cnt++;
            h = cur;
            cur = cur.next;
        }

        // cur = left, h = cur.pre
        ListNode r = cur, next = cur.next, pre = null;
        while (cnt <= right) {
            cnt++;
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 反转后, r是尾, pre是头, next是尾的尾, h是头的头
        r.next = next;
        if (h == null) { // 从head开始反转, 此时head是 cur
            return pre;
        } else {
            h.next = pre;
            return head;
        }
    }

}
