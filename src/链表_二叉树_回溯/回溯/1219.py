class Solution:
    def getMaximumGold(self, grid: list[list[int]]) -> int:
        # 从任意grid[i][j] > 0处dfs, 注意维护和回退visited
        # 由于visited = True 等价于 grid = 0, 可以优化
        n, m = len(grid), len(grid[0])
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        visited = [[False for _ in range(m)] for _ in range(n)]  # 建n*m False矩阵

        def dfs(i, j) -> int:
            if i < 0 or i >= n or j < 0 or j >= m or grid[i][j] == 0 or visited[i][j]:
                return 0

            visited[i][j] = True
            mx = 0
            for dir in dirs:
                mx = max(mx, dfs(i + dir[0], j + dir[1]))
            visited[i][j] = False
            return mx + grid[i][j]

        ans = 0
        for i in range(n):
            for j in range(m):
                ans = max(ans, dfs(i, j))
        return ans
