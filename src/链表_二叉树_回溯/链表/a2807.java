package 链表_二叉树_回溯.链表;

import java.math.BigInteger;

public class a2807 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 在每两个节点间插入一个节点, 需要知道前后两个节点的指针
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode front = head, behind = head.next;
        while (behind != null) { // 在front和behind之间插入一个节点
            ListNode node = new ListNode(gcd(front.val, behind.val), behind);

            // 插入节点
            front.next = node;

            // 移动指针
            front = behind;
            behind = behind.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
        // 原理: 假设a = b * q + r, d为a和b的公约数,
        // 那么对于r = a % b = a - b * q, d也是r的公约数, 因此(a, b)的公约数集合 = (b, a % b)的公约数集合
        // 当b = 0时, 对于上一步的(a, b)也就有a % b == 0, 此时的b是(a, b)的公约数集合中展现的第一个, 也就是最大公约数
    }

}
