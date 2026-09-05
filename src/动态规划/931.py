class Solution:
    def minFallingPathSum(self, matrix: list[list[int]]) -> int:
        # i, j可以移动到i+1, (j-1/j/j+1) -> 等价于, i+1, j可以从i, (j-1/j/j+1)移动而来
        # 总问题: 从0, j1 -> n-1, j2的权最小路径
        # 一般化: 从0, j1 -> i, j2的权最小路径, 无后效性
        # dp[i][j] = 从0, j1 -> i, j的权最小路径, j越界为无穷大, dp[0][j] = matrix[0][j]
        n = len(matrix)

        # dp[i][j+1] <-> matrix[i][j], 多设左右边界
        dp = [[float("inf") for _ in range(n + 2)] for _ in range(n)]
        for j in range(n):
            dp[0][j + 1] = matrix[0][j]

        for i in range(1, n):
            for j in range(n):
                dp[i][j + 1] = min(dp[i - 1][j], dp[i - 1][j + 1], dp[i - 1][j + 2]) + matrix[i][j]
        return min(dp[n - 1])
