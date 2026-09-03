class Solution:
    def rob(self, nums: list[int], colors: list[int]) -> int:
        # 假设偷了index, 并且index - 1同色, 那就不能偷i - 1 -> 选或不选分支, 取max
        length = len(nums)
        dp = [0] * (length + 1)
        dp[1] = nums[0]
        # dp[i] = [0, i)可偷的最大值
        for i in range(1, length):
            dp[i + 1] = max(dp[i], dp[i - 1] + nums[i]) if colors[i] == colors[i - 1] else dp[i] + nums[i]

        return dp[length]


# 准备重写....
