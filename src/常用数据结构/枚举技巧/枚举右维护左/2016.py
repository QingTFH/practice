class Solution:
    def maximumDifference(self, nums: list[int]) -> int:
        # 同样维护前缀最小值
        pre_min, ans = nums[0], -1
        for num in nums:
            ans = max(ans, num - pre_min)
            pre_min = min(pre_min, num)

        return ans if ans != 0 else -1
