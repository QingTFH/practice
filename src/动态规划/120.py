class Solution:
    def minimumTotal(self, triangle: list[list[int]]) -> int:
        # 从i, j只能移动到i+1, j或者i+1, j+1, 找出最小路径和
        # 反过来, i, j只能从i-1, j和i-1, j-1移动到
        # dp[i][j] = 从0, 0移动到i, j的最小路径和
        # -> dp[i][j] = min(dp[i-1][j], dp[i-1][j-1])
        # 需要将dp向上向左各拓展一格inf, 留dp[0][0] = 0
        n = m = len(triangle)  # 最后一行一定是n个数字
        dp = [[float("inf") for _ in range(m + 1)] for _ in range(n + 1)]
        dp[0][0] = 0
        for i in range(n):  # 网格图索引, 对应dp[i+1][j+1]
            for j in range(i + 1):  # 每行有i+1个数
                dp[i + 1][j + 1] = min(dp[i][j + 1], dp[i][j]) + triangle[i][j]
        return min(dp[n])  # 返回底层中的最小路径
