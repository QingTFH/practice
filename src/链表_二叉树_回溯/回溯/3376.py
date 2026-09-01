# energy初始值为0
# 每分钟, energy += x, x初始值为1
# 打开第i把锁的要求: energy >= strength[i]
# 打开第i把锁之后: energy -> 0, x += k
# 要求打开n把锁所需的最小时间

# 贪心: 当energy = i时, 打开可以打开的能量最大的锁, 但是贪心是错的！！！为什么错呢？
# 全排列：枚举打开i把钥匙的顺序的排列, 对于每个path判断它需要的耗时, 会TLE
# [....] + [a,b]和[b,a]是不同的全排列, 但是前面[....]的耗时是一致的

from functools import cache


class Solution:
    def findMinimumTime(self, strength: list[int], k: int) -> int:
        n = len(strength)
        path = [""] * n

        @cache
        def backTrace(index: int, onPath: int) -> int:
            # 剩余候选项为onPath中0的位, 已经选了index个位置, 因此此时x确定 -> onPath能获得的最小time是确定的, 可以cache
            # 用mask作onPath
            if index == n:
                return 0

            ans = float("inf")
            for i in range(n):
                on = onPath & (1 << i)
                if not on:
                    path[index] = strength[i]
                    ans = min(
                        ans,
                        (
                            backTrace(index + 1, onPath | (1 << i))
                            + (path[index] + (1 + index * k) - 1) // (1 + index * k)
                        ),
                    )
            return ans

        return backTrace(0, 0)
