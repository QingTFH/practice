package 链表_二叉树_回溯.二叉树;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private class bz {
        private int filter(int a, int b) {
            // 返回a, b中, 不是-1且较小的那个, 否则返回-1
            // if-else开销较小, 但是更丑陋
            if (a == -1 && b == -1)
                return -1;
            else if (a == -1)
                return b;
            else if (b == -1)
                return a;
            else
                return Math.min(a, b);
        }
    }
}
