package 链表_二叉树_回溯.链表;

public class a876 {

    // 找到链表的中间节点, 需要使用快慢指针, 保证behind是front的一半, 当front到末尾(null 或者 最后一个节点)时
    // behind恰好只走了一半的路程
    // 验证; 二者初始索引为1, 跳出时behind = x + 1, front = 2x + 1 = n或n+1 (n奇/n偶)
    // 则x = Math.floor(n / 2), 如果n是奇数则x+1恰好为中点, 如果n为偶数则x+1恰好为后中点, 如果要前中点可能需要初始索引为0?

    public ListNode middleNode(ListNode head) {
        ListNode behind = head, front = head;
        while (front != null && front.next != null) {
            behind = behind.next;
            front = front.next.next;
        }

        return behind;
    }

}
