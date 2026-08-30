class Solution:
    def minimumDeletions(self, nums: list[int]) -> int:
        if len(nums) == 1:
            return 1
        # 找到最小值, 最大值的索引, 此时数组被分为左中右三段(都不包含索引)
        # 路径 = 左+右 or 左+中 or 中+右, 返回最小值 + 2
        mn, mx = float("inf"), float("-inf")
        minIndex, maxIndex = 0, 0
        for i in range(len(nums)):
            if nums[i] < mn:
                mn = nums[i]
                minIndex = i
            if nums[i] > mx:
                mx = nums[i]
                maxIndex = i
        left, medium, right = (
            min(minIndex, maxIndex),  # 左闭右开
            max(minIndex, maxIndex) - min(minIndex, maxIndex) - 1,  # 开区间
            len(nums) - 1 - max(minIndex, maxIndex),  # 左开右闭
        )
        print(left, medium, right)
        return min(left + medium, left + right, medium + right) + 2
