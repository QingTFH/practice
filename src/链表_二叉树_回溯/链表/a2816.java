package 链表_二叉树_回溯.链表;

public class a2816 {

    // 445的乘法版, 众所周知a * 2 = a + a, 依旧照抄
    // 不对, 不同的调用方法会对同一个链表进行操作, 所以直接用addTwoNumber(a_reverse, a_reverse)不行
    // 真的不行吗? 有没有可能是add(reverse(a), reverse(a))不行?
    // 还真是, add(reverse, reverse)是可以的, 那就是add中调用两次reverse的时候变回来了

    public ListNode doubleIt(ListNode head) {
        // return reverse(mult2(reverse(head, null)), null);
        ListNode reverse = reverse(head, null);
        return reverse(add(reverse, reverse), null);
    }

    public ListNode mult2(ListNode head) {
        ListNode dm = new ListNode(-1, head), pre = dm;
        int cnt = 0; // 进位
        while (pre.next != null || cnt > 0) { // 只要有一边不为空就应该继续遍历
            if (pre.next == null) {
                pre.next = new ListNode(0);
            }
            ListNode node = pre.next;
            node.val = node.val * 2 + cnt;
            if (node.val >= 10) {
                node.val -= 10;
                cnt = 1;
            } else {
                cnt = 0;
            }
            pre = node;
        }

        return dm.next;
    }

    public ListNode add(ListNode l1, ListNode l2) {
        ListNode dm = new ListNode(-1, l1), pre = dm;
        int cnt = 0; // 进位
        while (l1 != null || l2 != null || cnt != 0) { // 只要有一边不为空就应该继续遍历
            ListNode node = (l1 == null ? new ListNode(0) : l1);
            node.val += (l2 == null ? 0 : l2.val) + cnt;
            if (node.val >= 10) {
                node.val -= 10;
                cnt = 1;
            } else {
                cnt = 0;
            }
            pre.next = node;
            pre = node;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }

        return dm.next;
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
}
