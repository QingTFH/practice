class Solution:
    def minScore(self, n: int, roads: list[list[int]]) -> int:
        # 找到节点1所在连通块中的最小distance
        # 解1: dfs
        # 图的dfs: 先建边数组, 再从节点出发, 需要使用visited标记

        g = [[] for _ in range(n)]  ## 稀疏图, 不开满n * n; g[i] = [[j, distance]]
        for i, j, distance in roads:
            g[i - 1].append([j - 1, distance])
            g[j - 1].append([i - 1, distance])

        visited = [False] * n
        ans = float("inf")

        # 对于某个节点, 找到这个节点上的所有distance, 取最小值;
        # 如果所连接的节点还没dfs过, 就继续dfs
        def dfs(node: int) -> None:
            visited[node] = True
            nonlocal ans
            for y, distance in g[node]:
                if distance > 0:  # node -> i有边
                    ans = min(ans, distance)
                    if not visited[y]:
                        dfs(y)

        dfs(0)
        return ans
