package 链表_二叉树_回溯.链表;

public class a19 {

    public class ListNode { // 每次都要复制一个, 感觉可以用banzi.java来存, 然后import啊
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 前后指针, 先让前指针走n步, 再一起走, 直到前指针到达尾巴
    // dummy node确实好用啊, 只要是“可能修改head节点”的操作都可以使用(第二次评价)

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head), front = head, behind = head, pre = dummy;
        for (int i = 0; i < n; i++)
            front = front.next; // 先走n步, behind和front间的距离为n
        while (front != null) {
            pre = behind;
            behind = behind.next;
            front = front.next;
        }
        // 跳出时,  front = null, 距离为1的是倒数第1个节点, 距离为n的是倒数第n个节点, 也就是behind
        pre.next = behind.next;
        return dummy.next;
    }

}
