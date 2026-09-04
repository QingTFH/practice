class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # 类似64, 方案数, 本题dp[i][j] = 从0, 0到达i, j有多少方案
        # dp[i][j] = dp[i-1][j] + dp[i][j-1], 越界为0
        dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]  # dp[i][j]对应网格[i-1][j-1]
        dp[1][1] = 1

        for i in range(n):  # 网格图索引
            for j in range(m):
                if i == 0 and j == 0:
                    continue
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j]
        return dp[n][m]

    # 也可以把 f[0][1] 初始化成 1，这样我们无需单独计算 f[1][1]。
    # 从 dfs 的角度理解，就是把 (−1,0) 当作起点，且第一步只能往下走
    # 有点类似链表中的dummy-node
