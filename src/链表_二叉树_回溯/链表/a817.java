package 链表_二叉树_回溯.链表;

import java.util.Arrays;
import java.util.HashSet;

public class a817 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 用hashset存储nums
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);
        int cnt = 0;
        int result = 0; // 统计组件个数, 当cnt = 1时即为一个新组件
        while (head != null) {
            if (set.contains(head.val))
                cnt++;
            else
                cnt = 0;

            if (cnt == 1)
                result++;
            head = head.next;
        }
        return result;
    }

}
