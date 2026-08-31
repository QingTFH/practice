# "选下一个"型回溯, 当size = k时停止
class Solution:
    def combine(self, n: int, k: int) -> list[list[int]]:
        ans, path = [], []

        # 候选项是[start : n]
        def dfs(start) -> None:
            size = len(path)
            if size == k:
                ans.append(path.copy())
                return

            for num in range(start, n + 1):
                path.append(num)
                dfs(num + 1)
                path.pop()

        dfs(1)
        return ans


# "选或不选"型回溯
class Solution2:
    def combine(self, n: int, k: int) -> list[list[int]]:
        ans, path = [], []

        # index选或不选
        def dfs(index) -> None:
            size = len(path)

            if size == k:
                ans.append(path.copy())
                return

            # 候选项为[index : n], 共有n-i+1个数, 如果弥补不了缺口就剪枝
            if n - index + 1 < k - size:
                return

            dfs(index + 1)  # 不选

            path.append(index)  # 选
            dfs(index + 1)
            path.pop()

        dfs(1)
        return ans
