package 链表_二叉树_回溯.链表;

public class a86 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1, head), p = dummy;
        ListNode d2 = new ListNode(-1, null), p2 = d2;
        while (p.next != null) { // 操作p.next将其归类
            ListNode node = p.next;

            if (node.val >= x) { // 将其分到p2上, 如果删除了p.next, 那么下一步依然要操作p.next(此时是下一个next), 因此p不移动
                p2.next = node;
                p.next = node.next;
                node.next = null;
                p2 = node;
            } else {
                p = p.next;
            }
        }

        p.next = d2.next;
        return dummy.next;
    }

}
