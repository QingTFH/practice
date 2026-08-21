package 链表_二叉树_回溯.链表;

public class lcr_029 {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public Node insert(Node head, int insertVal) {
        // 遍历找到"node.val <= insertVal && node.next.val >= insertVal的位置, 否则找到最大/小值的位置"
        // 对于后者, 也就是在边界上, 它大于二者或小于二者;
        // 边界:node.next < node
        if (head == null) {
            Node result = new Node(insertVal);
            result.next = result;
            return result;
        }

        Node insertNode = new Node(insertVal);
        if (head.next == head) {
            insertNode.next = head;
            head.next = insertNode;
            return head;
        }

        int max = 0, min = Integer.MAX_VALUE, flag = 0;
        Node node = head;
        while (node != head || flag == 0) {
            max = Math.max(node.val, max);
            min = Math.min(node.val, min);
            node = node.next;
            flag = 1;
        }

        while (true) {
            if ((node.val <= insertVal && node.next.val >= insertVal)
                    || ((node.val == max && node.next.val == min)
                        && ((insertVal >= max) || (insertVal <= min)))) { // 应该插入的位置
                insertNode.next = node.next;
                node.next = insertNode;
                break;
            }
            node = node.next;
        }
        return head;
    }

}
