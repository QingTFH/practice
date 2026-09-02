from functools import cache


class Solution:
    def combinationSum4(self, nums: list[int], target: int) -> int:
        # 只要求排列个数, 不要求具体排列, 可以使用dp而非回溯
        # 假设总和为target时方案数为dp(target), 它是怎么得出来的呢？
        # 假设最后一步选择num[i]作为组合末, 那么此前的和为target - num, 此分支问题退化为dp(target - num)
        # 因此, dp(i) = sum(dp(i - num) for num in nums)
        # 边界条件: dp(i < 0) = 0, dp(0) = 1(空集)
        # 重复? -> 顺序不同的序列被认为不同的组合(本质排列) 并且 num[i] != num[j]
        @cache
        def dfs(i: int) -> int:
            if i < 0:
                return 0
            if i == 0:
                return 1

            return sum(dfs(i - num) for num in nums if num <= i)  # 提前剪枝: 如果num > i, 会进入dfs(i < 0)

        return dfs(target)
