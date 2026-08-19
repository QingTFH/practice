package 链表_二叉树_回溯.链表;

import java.util.List;

public class a2181 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 感觉原地操作不如新建一个链表

    public ListNode mergeNodes(ListNode head) {
        ListNode ans = null;
        ListNode node = ans;

        while (head.next != null) { // 最后一个节点固定是0, 直接忽略它
            if(head.val == 0) { // 如果是0
                if(ans == null) { // 如果是第一个0, 就把node和ans都设置
                    ans = new ListNode(0);
                    node = ans;
                } else { // 否则, 只移动node
                    node.next = new ListNode(0);
                    node = node.next;
                }
            } else { // 不是0, 直接将值加到node上
                node.val += head.val;
            }
            head = head.next;
        }

        return ans;
    }
}
