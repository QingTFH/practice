from functools import cache


class Solution:
    def countHousePlacements(self, n: int) -> int:
        # 两侧互不影响，直接是打家劫舍**2即可
        mod = int(1e9 + 7)

        @cache
        def dp(end: int) -> int:
            # [0, end]闭区间, 有几种放置情况
            if end < 0:
                return 1

            return dp(end - 2) + dp(end - 1)

        return ((dp(n - 1) % mod) ** 2) % mod
