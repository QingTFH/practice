package 链表_二叉树_回溯.链表;

import java.util.Map;

public class a2058 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode front = head, now = front.next, next = now.next;
        int firstIndex = -1, lastIndex = -1, index = 1;
        int min = Integer.MAX_VALUE;
        while (next != null) {
            if((now.val > next.val && now.val > front.val) ||
                    (now.val < next.val && now.val < front.val)) { // now是临界点
                if (firstIndex == -1) firstIndex = index;
                if (lastIndex != -1) min = Math.min(index - lastIndex, min);
                lastIndex = index;
            }

            front = now;
            now = next;
            next = next.next;
            index++;
        }

        if (min != Integer.MAX_VALUE) {
            return new int[]{min, lastIndex - firstIndex};
        } else {
            return new int[]{-1,-1};
        }
    }

}
