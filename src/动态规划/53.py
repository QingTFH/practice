class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        # 假设当前在index, 其中[0: index - 1]的子数组最大和是dp(index - 1)
        # 那么dp(index)有两种可能：dp(index - 1) + nums[index] 或 nums[index] (放弃前面的数组最大和), 另起炉灶
        # 由于子数组是连续的, 因此nums[i]是必选的, 因此, dp[i] = 包含i的前缀最大子数组和
        n = len(nums)
        dp = [0] * n
        dp[0] = mx = nums[0]
        for i in range(1, n):
            dp[i] = max(0, dp[i - 1]) + nums[i]
            mx = max(mx, dp[i])
        return mx
