class Solution:
    def minSwaps(self, nums: list[int]) -> int:
        # 统计一共有k个1, 因此最后会有一个长为k的全1窗口, 或者长为n-k的全0窗口(1在边界聚合的情况)
        # 因此定长滑窗, 确定窗口的最大值(1的个数的最大值), k - max即为前者的答案;
        # 后者: 要将窗口内的1全部换出, 因此min即为答案
        k, n = sum(x for x in nums), len(nums)
        if k == 0 or k == n:
            return 0

        sum_part, l, max_part = 0, 0, 0
        for r, x in enumerate(nums):
            sum_part += x
            # 窗口: [l, r], 合法化:长度为k
            while r - l + 1 > k:
                sum_part -= nums[l]
                l += 1
            if r - l + 1 == k:
                max_part = max(max_part, sum_part)

        sum_part, l, min_part = 0, 0, float("inf")

        for r, x in enumerate(nums):
            sum_part += x
            # 窗口: [l, r], 合法化:长度为k
            while r - l + 1 > n - k:
                sum_part -= nums[l]
                l += 1
            if r - l + 1 == n - k:
                min_part = min(min_part, sum_part)

        return min(k - max_part, min_part)
