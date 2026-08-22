package 链表_二叉树_回溯.链表;

public class a2095 {

    // 可能删除head节点(n = 1), 需要使用dummy
    // 本来想试试从dummy开始的快慢指针, 但是head != null没必要, 而且也会导致pre初始化为null, 违背dummy的初心

    public ListNode deleteMiddle(ListNode head) {
        ListNode behind = head, front = head, dummy = new ListNode(-1, head), pre = dummy;
        while (front != null && front.next != null) {
            pre = behind;
            behind = behind.next;
            front = front.next.next;
        }

        pre.next = behind.next;

        return dummy.next;
    }

}
