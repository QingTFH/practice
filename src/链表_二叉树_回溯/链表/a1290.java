package 链表_二叉树_回溯.链表;

public class a1290 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) { // val = 0 或 1
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }



    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) { // 由于我们只对当前节点进行操作, 所以是head != null 而非head.next != null
            result *= 2;
            result += head.val;
            head = head.next;
        }
        return result;
    }

}
