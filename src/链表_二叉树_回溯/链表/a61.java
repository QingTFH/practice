package 链表_二叉树_回溯.链表;

public class a61 {

    // 实际上是"将尾巴插到头部"k次, 假设链表长度length, 实际上只要操作length % k次(毕竟每进行k次就是回到原来的样子)
    // 那么, 也就是将最后length % k个节点移到最前面, 假设倒数第k % length个节点为h, pre.next = h, 链表尾为tail
    // 操作为: pre.next = null, tail.next = head, head = h

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        // 1. 计算length, 找到tail
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) { // tail是第cnt个节点
            length++;
            tail = tail.next;
        }
        if (k % length == 0)
            return head;

        // 2. 前后指针找到pre和h
        ListNode front = head, behind = head, pre = null; // pre应该是dummy吗?
        for (int i = 0; i < k % length; i++) {
            front = front.next;
        }
        while (front != null) { // 至少触发一次, pre一定不为null, 不需要dummy
            pre = behind;
            behind = behind.next;
            front = front.next;
        }

        // 3. 将behind ~ tail这一段移到头
        tail.next = head;
        pre.next = null;
        return behind;
    }

}
