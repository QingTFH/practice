package 链表_二叉树_回溯.链表;

public class a328 {

    // 两个head和cur

    public ListNode oddEvenList(ListNode head) {
        ListNode d = new ListNode(-1, head), pre = d; // 奇数链表的dummy和循环pre
        ListNode d2 = new ListNode(-1, null), t2 = d2; // 偶数链表的dummy和tail
        while (pre.next != null && pre.next.next != null) { // 处理pre的后两个位置, 第一个是奇, 第二个是偶
            // 需要移动的是pre.next.next(偶), 将pre.next链接到更下一个点上, 将pre.next.next移动到t2上
            ListNode node = pre.next, next = node.next; // node奇, next偶
            node.next = next.next;
            t2.next = next;
            next.next = null;

            pre = node;
            t2 = next;
        }
        // 跳出时, pre是奇的尾或尾的前一个, d2是偶的dummy

        if (pre.next != null)
            pre = pre.next;


        pre.next = d2.next;
        return d.next;
    }

}
