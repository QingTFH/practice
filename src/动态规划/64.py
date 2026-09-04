class Solution:
    def minPathSum(self, grid: list[list[int]]) -> int:
        # i, j从0, 0 到n, m, 每次要么i+1, 要么j+1
        # 假如我在i, j, 从0, 0到这里的最小cost是多少呢? -> (i-1, j)和(i, j-1)中的较小值 + grid[i][j]
        # 对于上, 左边界, 只有其中一个来路, 越界处设为无穷, 或者直接初始化?
        n, m = len(grid), len(grid[0])
        dp = [[0 for _ in range(m)] for _ in range(n)]
        dp[0][0] = grid[0][0]
        for i in range(1, m):  # (0, 1) -> (0, m)
            dp[0][i] = dp[0][i - 1] + grid[0][i]

        for i in range(1, n):  # (1, 0) -> (n, 0)
            dp[i][0] = dp[i - 1][0] + grid[i][0]

        for i in range(1, n):  # (1, 1) -> (n, m)
            for j in range(1, m):
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]

        return dp[n - 1][m - 1]
