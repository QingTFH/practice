class Solution:
    def countPathsWithXorValue(self, grid: list[list[int]], k: int) -> int:
        # 要求路径上所有grid[i][j]相异或的值 = k，每次可以i+1/j+1, 统计路径数
        # 假如我现在已经到了(n-1, m-1), 并且异或和为k, 前面所有位置的和只能是k ^ grid[n-1][m-1]
        # 问题转换成: (0, 0) -> (n-2, m-1), 异或和为k ^ grid[n-1][m-1]的路径数
        n, m = len(grid), len(grid[0])
