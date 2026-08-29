package 链表_二叉树_回溯.回溯;

public class a1863 {

    // 同78, 找到子集, 求子集的异或和
    // 值得注意的是, a ^ b = c <-> a ^ c = b, 因此复原现场的时候可以直接pre ^= nums[i]

    int pre = 0, result = 0;
    int[] nums;

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        dfs(0);
        return result;
    }

    private void dfs(int index) { // 选index or 不选
        if (index == nums.length) { // 所有数字都判定完了, 此时是答案
            result += pre;
            return;
        }

        dfs(index + 1); // 不选index

        pre ^= nums[index]; // 选index
        dfs(index + 1);
        pre ^= nums[index];
    }

}
