package 链表_二叉树_回溯.链表;

public class a2 {

    // 逆序存储, 所以个位在前, 合并到l1上

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dm = new ListNode(-1, l1), pre = dm;
        int cnt = 0; // 进位
        while (l1 != null || l2 != null || cnt != 0) { // 只要有一边不为空就应该继续遍历
            ListNode node = (l1 == null ? new ListNode(0) : l1);
            node.val += (l2 == null ? 0 : l2.val) + cnt;
            if (node.val >= 10) {
                node.val -= 10;
                cnt = 1;
            } else {
                cnt = 0;
            }
            pre.next = node;
            pre = node;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }

        return dm.next;
    }

}
