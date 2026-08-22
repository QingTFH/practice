package 链表_二叉树_回溯.链表;

public class a24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 在head可能发生变动时, 使用dummynode确实可以大幅简化逻辑判断, 取消了head的特殊性
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head), cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            // 交换: 对cur.next和cur.next.next进行交换,
            ListNode node = cur.next, next = node.next;
            node.next = next.next;
            next.next = node;
            cur.next = next;

            cur = cur.next.next;
        }

        return dummy.next;
    }

}
