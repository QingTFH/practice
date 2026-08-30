class Solution:
    def firstStableIndex(self, nums: list[int], k: int) -> int:
        # 预统计前缀最大值和后缀最小值(都包含nums[i])
        n = len(nums)
        suffix_min = [0] * n
        suffix_min[n - 1] = nums[n - 1]
        for i in range(n - 2, -1, -1):
            suffix_min[i] = min(suffix_min[i + 1], nums[i])

        pre_max = 0
        for i, x in enumerate(nums):
            pre_max = max(pre_max, x)
            if pre_max - suffix_min[i] <= k:
                return i
        return -1
