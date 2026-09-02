from functools import cache


class Solution:
    def climbStairs(self, n: int) -> int:
        # 记忆化搜索: 自顶向下: 我还剩几层 -> 我有几种方法

        @cache
        def dfs(left) -> int:
            if left < 0:
                return 0
            if left == 0:
                return 1

            return dfs(left - 1) + dfs(left - 2)

        return dfs(n)


class Solution2:
    def climbStairs(self, n: int) -> int:
        # 自底向上/回头看的视角：我是怎么到达这个位置的？
        # 对应：从0层到达index层有几种方案
        # 假如上一步走了1格，等价于“走到index - 1时，有几种方案” * 1
        # 假如上一步走了2格同理
        # 边界情况：f0 = 1, f1 = 1, f2 = 2
        if n == 1:
            return 1

        f0 = f1 = 1
        for _ in range(2, n + 1):  # 每次循环一轮结束时, f1 = f[index]
            f_new = f0 + f1
            f0 = f1
            f1 = f_new
        return f1
