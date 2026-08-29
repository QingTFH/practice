package 链表_二叉树_回溯.回溯;

public class a2044 {

    // 所有数或起来就是最大值
    int max = 0;
    int[] ns;
    int pre = 0;

    public int countMaxOrSubsets(int[] nums) {
        ns = nums;
        for (int n : nums)
            max |= n;

        return dfs(0);
    }

    private int dfs(int index) {
        if (pre == max) { // 剪枝: 如果此时pre已经等于max, 那么[index, length - 1]无论怎么选, 都有pre = max, 有2^(length - index)种情况
            return (int) Math.pow(2, ns.length - index);
        }

        if (index == ns.length)
            return 0;   // 由于前面已经判断了pre == max, 因此此条路一定不成立

        int r = 0;

        r += dfs(index + 1);

        int tmp = pre;      // 如果pre作为参数传递, 因为是基元不用返回现场; 但是我选择外部变量, 所以要返回现场;
        // 不过问题不大, 统一写法就行
        pre |= ns[index];
        r += dfs(index + 1);
        pre = tmp;

        return r;
    }

}
