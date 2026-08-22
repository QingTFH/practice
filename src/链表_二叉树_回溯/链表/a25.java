package 链表_二叉树_回溯.链表;

public class a25 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 类似a92, 先找到翻转区的左右两侧端点, 头插法翻转完中间后再连接
    // 感觉逻辑没那么复杂, 但是实现写得复杂了, 可能应该再分子方法来处理?

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head), pre = dummy;
        while (true) {
            // pre是翻转区的左侧第一个节点, 从pre.next开始反转k个节点
            ListNode node = pre.next;

            // 1. 先确定是否有右边界
            int cnt = 1;
            while (cnt < k && node != null) {
                cnt++;
                node = node.next;
            }

            // 正常跳出时, cnt = k, node是第k个节点
            if (cnt != k || node == null) { // 异常跳出, 说明node = null, 没有凑满k个节点, 不翻转
                break;
            }
            ListNode next = node.next; // 右边界的下一个端点

            // 2. 再次从pre.next开始遍历, 正常进行翻转, 翻转后pre.next = h, tail.next = next, 更新pre = tail
            ListNode tail = pre.next; // 翻转后的尾
            ListNode h = reverseK(pre.next, k); // 翻转后的头
            tail.next = next;
            pre.next = h;
            pre = tail;
        }
        return dummy.next;
    }

    private ListNode reverseK(ListNode head, int k) {
        // 翻转从head开始的k个节点, 返回反转后的head
        ListNode pre = null;
        for (int cnt = 0; cnt < k; cnt++) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
