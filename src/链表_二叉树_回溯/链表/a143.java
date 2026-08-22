package 链表_二叉树_回溯.链表;

public class a143 {

    // 要空间复杂度O(1)的话, 类似2130, 两端遍历的节点为一组
    // 有head段的node1 和 tail段的node2, 记录next = node2.next,
    // 更改node2.next = node1.next, node1.next = node2, 下一次遍历head端为node2.next, tail端为next(这个命名真是绕晕我了)
    // 边界情况: 如果size为奇数, 此时middle在head端(因为先放head端的元素), 最后一次时tail = null, 没有tail.next
    // 由于head端的一直在链表中, 这一步就不需要操作, 直接设next = null即可

    // 感觉这样写逻辑上依然比较丑陋

    public void reorderList(ListNode head) {
        // 1. 找到后中点, 或者中点的下一个节点
        ListNode middle = findMiddle(head);

        // 2. 反转后半, 确定tail
        ListNode tail = reverse(middle, null); // 这一段应该断开, 因为tail端不需要知晓middle, 也不需要middle作为终止条件

        // 3. 两端遍历, 直接更改head端
        ListNode cur = head; // head端的遍历子, 因为不能改变head
        while (tail != null) {
            ListNode next = tail.next;
            tail.next = cur.next;
            cur.next = tail;
            cur = tail.next;
            tail = next;
        }

        // 跳出时, 可能两边的遍历结束, 此时cur = tail.next = null;
        // 可能head端还差一个middle才结束, 此时cur = middle且middle.next != null, 需要修正
        if (cur != null) cur.next = null;
    }

    private ListNode findMiddle(ListNode head) {
        // 返回后中点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        return slow;
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
