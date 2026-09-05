class Solution:
    def countPathsWithXorValue(self, grid: list[list[int]], k: int) -> int:
        # 要求路径上所有grid[i][j]相异或的值 = k，每次可以i+1/j+1, 统计路径数
        # 假如我现在已经到了(n-1, m-1), 并且异或和为k, 前面所有位置的和只能是k ^ grid[n-1][m-1]
        # 问题转换成: (0, 0) -> (n-2, m-1), 异或和为k ^ grid[n-1][m-1]的路径数, 依然不是无后效问题
        # 只要把"异或和"也加入dp参数中就无后效了，没毛病

        # 用cache记忆化搜索会MLE，因为cache是{tuple:int}, 需要用数组降内存;
        # 由于grid[i][j] < 16 = 2^4 -> 异或和 < 16 -> 开大小为16的数组即可
        # dp[i][j][sum]
        # 如果没有这么小的范围，最内层可能需要开dict: 异或和:路径数
        n, m, mod = len(grid), len(grid[0]), int(1e9 + 7)
        dp = [[[0 for _ in range(16)] for _ in range(m)] for _ in range(n)]
        # 边界条件: 越界恒为0, dp[0][0][grid[0][0]] = 1
        dp[0][0][grid[0][0]] = 1

        for i in range(n):
            for j in range(m):
                if i == 0 and j == 0:
                    continue
                for xor in range(16):
                    prexor = xor ^ grid[i][j]
                    left = 0 if j - 1 < 0 else dp[i][j - 1][prexor]
                    up = 0 if i - 1 < 0 else dp[i - 1][j][prexor]
                    dp[i][j][xor] = (left + up) % mod

        return dp[n - 1][m - 1][k]
