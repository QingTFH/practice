class Solution:
    def uniformArray(self, nums1: list[int]) -> bool:
        # 比3875多了一个条件:
        # nums2[i] = nums1[i] - nums1[j]时, 要求 j != i，且 nums1[i] - nums1[j] >= 1
        # 假如n1有奇有偶: 构造全奇, 要求nums1[i]偶且存在nums[j]奇且nums1[i] > nums1[j] -> 最小奇数比最小偶数小
        #                构造全偶，要求nums[i]奇且存在nums[j]奇且nums[i] > nums[j] -> 对于最小奇数不存在
        # 综上, 统计最小奇数 和 最小偶数, 如果有一方不存在则true， 如果都存在返回 奇 > 偶
        min_odd = min((x for x in nums1 if x % 2 == 1), default=None)
        min_even = min((x for x in nums1 if x % 2 == 0), default=None)
        return min_even is None or min_odd is None or min_odd < min_even
