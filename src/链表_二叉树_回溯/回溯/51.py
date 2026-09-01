# N皇后: 每一行/列/斜线都只能有一个皇后'Q', 其他都是空位'.'
# 全排列式N皇后: 枚举第index行的皇后在第col列的情况, 如果后续能放完则合法, 否则不合法
#   由于index逐步新增, 因此不会重复
#   由于col是从候选st里选择，因此不会重复
#   要考虑的就是斜线的不重复性，一条方向上是y = x + b -> y - x = b, 另一个方向是y + x = b,
#   因此只要b不重复，就没有重复的斜线
class Solution:
    def solveNQueens(self, n: int) -> list[list[str]]:
        row, colOnPath = [], [False] * n
        ans = []

        # row[index] = 第index行的皇后放在第row[index]列
        def canPut(col: int) -> bool:
            n = len(row)
            for r, c in enumerate(row):
                if r - c == n - col or r + c == n + col:
                    return False
            return True

        def backTrace() -> None:
            if len(row) == n:
                result = []
                for col in row:
                    temp = ["."] * n
                    temp[col] = "Q"
                    result.append("".join(temp))
                ans.append(result.copy())
                return

            for i, on in enumerate(colOnPath):
                if not on and canPut(i):
                    colOnPath[i] = True
                    row.append(i)
                    backTrace()
                    row.pop()
                    colOnPath[i] = False

        backTrace()
        return ans
