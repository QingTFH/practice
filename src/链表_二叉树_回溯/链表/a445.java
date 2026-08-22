package 链表_二叉树_回溯.链表;

public class a445 {

    // 2的未翻转版, 翻转一下相加再翻转即可, 抄一下以前的方法一分钟写完

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverse(add(reverse(l1, null), reverse(l2, null)), null);
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
