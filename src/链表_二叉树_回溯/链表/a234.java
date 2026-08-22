package 链表_二叉树_回溯.链表;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class a234 {

    // 先找到后中点(如果length是奇数, 则找到中点的下一个), 记录前半段的值到栈中, 逐个比较栈顶和后半段的值
    // 如果要求O(1)空间复杂度，则要将前/后半段链表反转再逐个比对
    // 时间复杂度应该是O(n)没问题, 但是耗时偏长, 可能是stack的操作比较费时?

    // 耗时: Integer装箱拆箱, 内存操作耗时大

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode middle = middleNode(head, stack);
        while (middle != null) {
            if(middle.val != stack.pop())
                return false;
            middle = middle.next;
        }

        return true;
    }

    public ListNode middleNode(ListNode head, Deque<Integer> stack) {
        ListNode behind = head, front = head;
        while (front != null && front.next != null) {
            stack.push(behind.val);
            behind = behind.next;
            front = front.next.next;
        }

        if (front != null) behind = behind.next;
        return behind;
    }

    public boolean isPalindrome2(ListNode head) {
        // 1. 找到中点middle
        ListNode middle = middleNode2(head);

        // 2. 将后半段反转, 变成tail -> ~ -> middle
        ListNode pre = middle, cur = pre.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 此时pre是tail

        // 3. head/tail遍历, 直到tail端经过middle, 注意同样要检查middle
        // 对于tail端, 跳出时应该恰好tail = middle.pre(因为middle依然保持从左到右), 无法实现
        // 对于head端, 跳出时恰好head = middle(middle为后中点), 对应最后一次检查为前中点 == middle,可以实现
        while (head != middle) {
            if (pre.val != head.val)
                return false;

            pre = pre.next;
            head = head.next;
        }

        return true;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode behind = head, front = head;
        while (front != null && front.next != null) {
            behind = behind.next;
            front = front.next.next;
        }

        return behind;
    }

}
