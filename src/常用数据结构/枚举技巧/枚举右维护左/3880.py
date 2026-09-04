class Solution:
    def minAbsoluteDifference(self, nums: list[int]) -> int:
        # 对于nums[j] == 2, 他要找离他最近的nums[i] == 1, 维护前缀
        pre_i, pre_j, ans = -1, -1, 100
        for i, num in enumerate(nums):
            if num == 1:
                if pre_j != -1:
                    ans = min(ans, i - pre_j)
                pre_i = i
            if num == 2:
                if pre_i != -1:
                    ans = min(ans, i - pre_i)
                pre_j = i
        return ans if ans != 100 else -1
