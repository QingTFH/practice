package 链表_二叉树_回溯.二叉树;

public class a1145 {

    // 可以堵住一号的较大面 -> 假如一号选定的节点为a, 如果a的左子树还有比较多的节点数, 则选择它的左孩子染色, 这样可以完全堵住它的左子树的所有节点
    // 作为代价, 我也只能占据这一块地盘, 不过这是最优解了;

    // 计算x的左/右子树的节点数, 记为l, r;我右三个区域可以选择:l, r, n-(l+r+1); 如果其中一个区域的节点数大于一半, 则我选择这个区域后获胜
    // 由于n是奇数, 没有平局情况
    // 查询0x3f的题解, 与我思路一致;

    // 要找到x所在的节点似乎只能遍历...示例的顺序情况只是特解

    int lr, rr, x;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        dfs(root); // 获取lr, rr
        int a = Math.max(Math.max(lr, rr), n-lr-rr-1);
        System.out.println(a+","+lr+"," + rr+",");
        return a > n / 2;
    }

    private int dfs(TreeNode node) { // 计算当前子树的大小
        if (node == null)
            return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);

        if (node.val == x) {
            lr = l;
            rr = r;
        }

        return l + r + 1;
    }

}
