package 链表_二叉树_回溯.链表;

public class a142 {

    // 类似141, 但是需要讨论一下"从第k个节点开始成环"的问题;
    // 假设相遇时, slow 在索引p, 路程为a + b; fast也在索引p, 路程为a + b + n*size
    // a是环外的路程, b是slow在环内的路程
    // 由于路程一定是两倍, 因此2 * (a+b) = a + b + n*size
    // 因此n * size = a + b恒成立, 而p距离环的初始位置还需要走(size - b) = a - (n-1)*size,
    // 由于在环内走x * size的路程等于没走, 所以slow/fast只需要再走a距离就到入环口
    // 如何再走a距离呢? 再创建一个慢指针, 它到入环口的时候走过的距离是a, 此时slow恰好也走过a, 因此他俩会在入环口相遇

    // 实现上, 创建slow和fast, 它们第一次相遇时创建slow2, 返回slow2和slow相遇时的节点

    // 推导得我好难受

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // 跳出时, 如果是异常状态(无环), 直接返回null, 否则进入下一步
        if (fast == null || fast.next == null)
            return null;

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

}
