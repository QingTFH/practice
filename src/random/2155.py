class Solution:
    def maxScoreIndices(self, nums: list[int]) -> list[int]:
        # 依旧前缀和
        one_right, zero_left, mx = nums.count(1), 0, 0
        ans = []
        for i in range(len(nums) + 1):
            # 每一步将i-1放入nums_left
            if i > 0:
                if nums[i - 1] == 1:
                    one_right -= 1
                else:
                    zero_left += 1
            score = zero_left + one_right
            if score > mx:
                mx = score
                ans = [i]
            elif score == mx:
                ans.append(i)
        return ans
