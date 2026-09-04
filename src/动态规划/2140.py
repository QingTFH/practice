class Solution:
    def mostPoints(self, questions: list[list[int]]) -> int:
        # 打家劫舍变种, 单侧跳过questions[i][1]个元素
        # dp[i] == [i : end]可获得的最大分数
        # dp[i] = max(dp[i+1], questions[i][0] + dp[i + 1 +questions[i][1]])
        # 边界: dp[i > end] == 0, dp[end] = questions[end][0]
        n = len(questions)
        dp = [0] * n
        dp[n - 1] = questions[n - 1][0]
        for i in range(n - 2, -1, -1):
            dp_pre = 0 if i + 1 + questions[i][1] >= n else dp[i + 1 + questions[i][1]]
            dp[i] = max(dp[i + 1], questions[i][0] + dp_pre)
        return dp[0]
