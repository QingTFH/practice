class Solution:
    def maxAreaOfIsland(self, grid: list[list[int]]) -> int:
        n, m = len(grid), len(grid[0])
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        mx = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] > 0:

                    def dfs(i: int, j: int) -> int:
                        if i < 0 or i >= n or j < 0 or j >= m or grid[i][j] == 0:
                            return 0
                        r = 1
                        grid[i][j] = 0
                        for dir in dirs:
                            r += dfs(i + dir[0], j + dir[1])
                        return r

                    mx = max(mx, dfs(i, j))
        return mx
