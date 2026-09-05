class Solution:
    def minCost(self, m: int, n: int, waitCost: list[list[int]]) -> int:
        # m是行数, n是列数
        # 进入成本：走到 (i, j) 的成本为 (i + 1) * (j + 1)
        # 等待成本: wait[i][j]
        # 只能i+1 or j+1; 除了走到m-1, n-1和第一步进入0, 0外, 其余每步都会花费"进入成本"和"等待成本"
        # 总问题: 找到0, 0 -> m-1, n-1的最小花费
        # 边界: 越界恒无穷大, dp[0][0] = 1
        # 除了始末点外，其余每个位置的进入花费都是(i+1)*(j+1) + watiCost[i][j]

        # dp[i+1][j+1] <-> waitCost[i][j]
        dp = [[float("inf") for _ in range(n + 1)] for _ in range(m + 1)]
        dp[1][1] = 1

        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    continue
                dp[i + 1][j + 1] = min(dp[i][j + 1], dp[i + 1][j]) + waitCost[i][j] + (i + 1) * (j + 1)

        return dp[m][n] - waitCost[m - 1][n - 1]  # 终点无需等待
