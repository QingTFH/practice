package 链表_二叉树_回溯.链表;

public class a1721 {

    // 要求交换正数第k个节点和倒数第k个节点的值, 不要求交换节点, 不需要使用dummy
    // 直接找到正数k, 前后指针找到倒数k

    public ListNode swapNodes(ListNode head, int k) {
        ListNode f = head; // 正数k
        ListNode b = head, n = head.next; // b:倒数k, n:前指针
        for (int i = 1; i < k; i++) { // f向前走k-1步, 才是第k个节点, 因此n初始化为第2个节点, 最终和b的距离为n
            f = f.next;
            n = n.next;
        }

        while (n != null) {
            n = n.next;
            b = b.next;
        }

        int tmp = f.val;
        f.val = b.val;
        b.val = tmp;

        return head;
    }

}
