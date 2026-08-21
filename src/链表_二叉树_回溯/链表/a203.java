package 链表_二叉树_回溯.链表;

public class a203 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null;
        ListNode node = head;
        while (node != null) {
            if (node.val == val) { // 删除node
                if (pre == null) { // 要删除头节点, 直接移动head即可
                    head = node.next;
                    node = head;
                } else {
                    pre.next = node.next;
                    node = node.next;
                }
            } else { // 直接移动pre和head
                pre = node;
                node = node.next;
            }
        }

        return head;
    }

}
