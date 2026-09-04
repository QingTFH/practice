class Solution:
    def firstStableIndex(self, nums: list[int], k: int) -> int:
        # 对于每个下标，它的特殊值target_i = premax - sufmin, 包含nums[i]本身
        # 返回第一个target_i <= k的i, 否则-1
        n = len(nums)
        suffix_min = [float("inf")] * n
        suffix_min[n - 1] = nums[n - 1]
        for i in range(n - 2, -1, -1):
            suffix_min[i] = min(suffix_min[i + 1], nums[i])

        premax = 0
        for i, num in enumerate(nums):
            premax = max(num, premax)
            if premax - suffix_min[i] <= k:
                return i
        return -1
