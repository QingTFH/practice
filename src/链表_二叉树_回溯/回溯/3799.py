# "选下一个"回溯式模拟
class Solution:
    def wordSquares(self, words: list[str]) -> list[list[str]]:
        n, path, ans = len(words), [], []
        onPath = [False] * n

        def backTrace() -> None:
            if len(path) == 4:  # 底层, 看是否合法, 合法则加入ans
                top, left, right, bottom = path
                if top[0] == left[0] and top[3] == right[0] and bottom[0] == left[3] and bottom[3] == right[3]:
                    ans.append(path.copy())
                return

            for i, on in enumerate(onPath):
                if not on:
                    path.append(words[i])  # 没有提前剪枝是因为太麻烦了, 要判断当前位置
                    onPath[i] = True
                    backTrace()
                    onPath[i] = False
                    path.pop()

        backTrace()
        return sorted(ans)
