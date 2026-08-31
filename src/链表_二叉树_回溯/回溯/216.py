# 和为n的k个不同的[1:9]的数

# "选下一个"
class Solution:
    def combinationSum3(self, k: int, n: int) -> list[list[int]]:
        # 快速失败
        if sum(range(1, k + 1)) > n:
            return []

        ans, path = [], []

        # 本次候选项为[start : 9]
        def back_trace(start: int, sum: int, size: int) -> None:
            if size == k:
                if sum == n:
                    ans.append(path.copy())
                return

            if start > 9 or sum > n:
                return

            for end in range(start, 10):
                path.append(end)
                back_trace(end + 1, sum + end, size + 1)
                path.pop()

        back_trace(1, 0, 0)
        return ans
