class Solution:
    def minPathCost(self, grid: list[list[int]], moveCost: list[list[int]]) -> int:
        # 路径权重: sum(节点值) + sum(移动代价)
        # 移动代价: 值为val的节点, 移动到下一行的第j列, 代价为moveCost[val][j]
        # 总问题：找到0, j1 -> m-1, j2的最小路径权重
        # dp[i][j] = 0, j1 -> i, j的最小路径权重; 每个dp元素的时间复杂度是log(n)
        # 边界情况: 越界恒无穷大, dp[0][j] = grid[0][j]
        m, n = len(grid), len(grid[0])
        dp = [[float("inf") for _ in range(n)] for _ in range(m)]
        for i, num in enumerate(grid[0]):
            dp[0][i] = num

        for i in range(1, m):
            for j in range(n):
                dp[i][j] = min((dp[i - 1][k] + moveCost[grid[i - 1][k]][j]) for k in range(n)) + grid[i][j]
        return min(dp[m - 1])
