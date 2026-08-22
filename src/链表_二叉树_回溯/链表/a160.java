package 链表_二叉树_回溯.链表;

public class a160 {

    // 简单写法肯定是set

    // 看了题解, 双指针的写法是, 两个指针的路程相同, 则为a + c + b(a段, 共享段, b段)
    // 无论c = ?, 走完路程后指针相等; 如果c > 0, 返回的就是交叉点; 如果c = 0, 返回的就是null
    // 巧妙啊

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode da = new ListNode(-1), db = new ListNode(-1), pA, pB;
        da.next = headA;
        db.next = headB;
        pA = da;
        pB = db;

        while (pA != pB) {
            pA = pA == null ? db : pA.next;
            pB = pB == null ? da : pB.next;
        }

        return pA;
    }

}
