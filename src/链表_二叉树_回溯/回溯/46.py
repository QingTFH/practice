# 排列型回溯, 假设当前已经选的路径是path, 候选集合为s, 本质是在path + 1枚举s中的所有可能
class Solution:
    def permute(self, nums: list[int]) -> list[list[int]]:
        path, ans = [], []

        def back_trace(s: set) -> None:
            if len(s) == 0:
                ans.append(path.copy())
                return

            for x in s:
                path.append(x)
                back_trace(s - {x})
                path.pop()

        back_trace(set(nums))
        return ans
