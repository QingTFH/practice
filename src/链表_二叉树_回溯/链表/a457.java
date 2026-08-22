package 链表_二叉树_回溯.链表;

import java.util.HashSet;
import java.util.Set;

public class a457 {

    // 对于索引i, 它的下一个位置是i + nums[i], 这意味着nums[i]是一个有向边
    // 对于 i + nums[i] < 0 或 >= size的位置, 压缩回 0 ~ size-1的区间( (x % mod + mod) % mod )

    // 因为是数组, 所以一定成环
    // 满足"循环"的条件: 环序列[i1, i2, i3...]的nums[i*]同号

    // 不使用快慢指针的话, 感觉操作会更简单
    // 假如要优化成快慢指针, 该怎么做呢?

    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 初始索引为i, 初始方向为nums[i]
            // 每次判断是否方向一致、每次记录经过的节点, 确认会走入死胡同的置0
            // 对于导致走入死胡同的节点j, nums[j]不置0, 理由如下:
            // i1 -> i* -> j被判定为非法路径, 意味着nums[i*]同号且nums[j]不同号, 从i*进入的路径一定走到j,
            // 也就一定会判定为非法, 所以i*直接忽略;
            // 但是从另一条路x*走到j时, j可能是同号的, 因此不能忽略j
            if(nums[i] == 0)
                continue;

            Set<Integer> set = new HashSet<>();
            int index = i, next = next(nums, index);
            while (nums[next] != 0
                    && nums[index] * nums[next] > 0
                    && !set.contains(index)) {
                set.add(index);
                index = next;
                next = next(nums, index);
            }

            // 跳出时, 要么遇到环入口, 要么路径确认非法
            // 合法额外要求: 至少有两个不同元素, 也就是环入口的下一个元素不能是环入口
            if (set.contains(index) && index != next)
                return true;

            for (int a : set) {
                nums[a] = 0;
            }
        }
        return false;
    }

    private int next(int[] nums, int index) {
        int n = nums.length;
        return (((index + nums[index]) % n) + n) % n;
    }

}
