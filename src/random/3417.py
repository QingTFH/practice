class Solution:
    def zigzagTraversal(self, grid: list[list[int]]) -> list[int]:
        ans = []
        skip = False
        for i in range(len(grid)):
            # 如果是anti(i是奇数), 反向遍历该行, 否则正向
            # 如果skip, 跳过该格
            cur_row = reversed(grid[i]) if i % 2 != 0 else grid[i]
            for num in cur_row:
                if not skip:
                    ans.append(num)
                skip = not skip
        return ans
