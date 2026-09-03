from functools import cache


class Solution:
    def rob(self, nums: list[int]) -> int:
        # 假如我选择了index, 那么index - 1和index + 1也不能选了, 问题变成剩余子数组中的max
        # 考虑简化问题, 把index放在边界，这样子数组就只有一边;
        # 问题变成"index"选 or not
        @cache
        def dp(end: int) -> int:
            # 左闭右开, 统计[0 : end - 1]数组中的合法最大值
            if end <= 0:
                return 0

            return max(dp(end - 1), nums[end - 1] + dp(end - 2))

        return dp(len(nums))
