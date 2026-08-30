from functools import cache


class Solution:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        # 回溯, 倒推"当前长度有几种方案"
        # 子问题: 当前长度有几种方案
        # 操作: 剥离zero个'0' 或者 one个'1'
        # 下一个子问题: 剥离后的长度有几种方案
        # 边界情况: len < zero and len < one, 有0种方案
        # len == zero有1种方案, ==one同理
        mod = int(1e9 + 7)

        @cache
        def dfs(length: int) -> int:
            if length < 0:  # 非法边界
                return 0
            if length == 0:  # 合法边界
                return 1
            return (dfs(length - zero) + dfs(length - one)) % mod

        ans = 0
        for i in range(low, high + 1):
            ans += dfs(i) % mod
        return ans % mod
