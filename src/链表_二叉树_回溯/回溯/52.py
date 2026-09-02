class Solution:
    def totalNQueens(self, n: int) -> int:
        # 同51, 重写一次
        col, onPath = [-1] * n, [False] * n
        # col[index] = index行的皇后放在第col[index]列
        # onPath[index] = 第index列有没有被选过
        ans = 0

        def canPut(ro, co) -> bool:
            for r in range(ro):  # 由于col没有恢复现场而是直接覆盖, 只能认为[0, index - 1]是已放置的
                c = col[r]
                if ro + co == r + c or ro - co == r - c:
                    return False
            return True

        def back_trace(index: int) -> None:
            if index == n:
                nonlocal ans
                ans += 1
                print(col)
                return

            for c, on in enumerate(onPath):
                if not on and canPut(index, c):
                    col[index] = c
                    onPath[c] = True
                    back_trace(index + 1)
                    onPath[c] = False

        back_trace(0)
        return ans
