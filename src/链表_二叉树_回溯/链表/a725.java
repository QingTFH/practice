package 链表_二叉树_回溯.链表;

import java.util.List;

public class a725 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 分成k个部分, 长度尽量相同且不超过1, 前面部分更大
    // 对于每个部分, 基本长度为 head.length / k, 对于靠前的head.length % k 个部分要额外+1
    // 难点在实现

    public ListNode[] splitListToParts(ListNode head, int k) {
        // 1. 统计length
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        System.out.println(length);

        // 2. 分割链表
        ListNode[] result = new ListNode[k];

        // 原地操作, 每经过target个节点后更改node位置为next, 断掉连接, 放入该段的head
        node = head;
        int cnt = 0; // 这是第几段
        int l = 1; // 这是本段的第几个
        while (node != null) {
            // 对于每个节点, 如果它不是尾, 那么直接进入下一个位置;
            // 如果是尾, 则将一个tmp放到next, 断掉与next的连接, 将head放入result, 将head和node都设为tmp

            if (l >= (length / k) + ((cnt < length % k) ? 1 : 0)) { // 是本段最后一个
                result[cnt] = head;
                ListNode tmp = node.next;
                node.next = null;
                head = tmp;
                node = tmp;
                cnt++;
                l = 1;
            } else {
                node = node.next;
                l++;
            }
        }

        return result;
    }

}
