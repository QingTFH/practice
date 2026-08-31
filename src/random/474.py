from functools import cache


class Solution:
    def findMaxForm(self, strs: list[str], m: int, n: int) -> int:
        # 回溯 + 记忆化搜索伪装dp

        # nums[i] = [zero, one] = strs[i]有多少个0, 多少个1
        nums = []
        for s in strs:
            zero = s.count("0")
            nums.append([zero, len(s) - zero])

        # 递归方法: 选 or not -> 用zero_left个0 + one_left个1 可以构筑多长的length
        @cache
        def dfs(index: int, zero_left: int, one_left: int) -> int:
            if index == len(nums) or (zero_left == 0 and one_left == 0):
                return 0

            result = dfs(index + 1, zero_left, one_left)  # 不选

            if zero_left >= nums[index][0] and one_left >= nums[index][1]:  # 可以选
                result = max(
                    result,
                    dfs(
                        index + 1,
                        zero_left - nums[index][0],
                        one_left - nums[index][1],
                    )
                    + 1,
                )
            return result

        return dfs(0, m, n)
