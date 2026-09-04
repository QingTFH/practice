class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: list[list[int]]) -> int:
        # 障碍物处不可达, dp为0
        n, m = len(obstacleGrid), len(obstacleGrid[0])
        dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]  # dp[i][j]对应网格[i-1][j-1]
        dp[0][1] = 1  # 等价于: 起点改为(-1, 0), 且第一步只能走到(0, 0)

        for i in range(n):  # 网格图索引
            for j in range(m):
                if obstacleGrid[i][j] == 0:
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j]
        return dp[n][m]
