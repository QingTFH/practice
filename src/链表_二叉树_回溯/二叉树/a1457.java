package 链表_二叉树_回溯.二叉树;

import java.util.HashSet;
import java.util.Set;

public class a1457 {

    // 一个数字串是伪回文的, 当且仅当只有一个奇数个数的数字
    //      -> HashSet存储数字, 如果有则remove, 如果无则add, 最终set.size() <= 1
    // 外置set判断路径即可

    // 优化: set -> 数组 +=1, %=2 -> 数组 ^= 1
    // 由于数组中的每一位是0或1, 所以可以用二进制数 n 来代表数组, 而且基本类型可以当参数传递
    //      如果n只有一位是1, 例如10000, 那么n - 1 = 01111, n & (n-1) = 0 (n-1 = 将n中的第一位1置0, 并将所有低位置1, 因此n&(n-1)中, n的第一个1及更低位是全0)

    int result = 0;
    Set<Integer> path = new HashSet<>();

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;

        boolean cont = path.contains(node.val); // 此时path中有没有node.val, 记录以方便撤销
        if (cont) { // 布置现场
            path.remove(node.val);
        } else {
            path.add(node.val);
        }

        if (node.left == null && node.right == null) {
            if (path.size() <= 1)
                result ++;
        } else {
            dfs(node.left);
            dfs(node.right);
        }

        if (cont) {  // 回溯现场
            path.add(node.val);
        } else {
            path.remove(node.val);
        }
    }

}
