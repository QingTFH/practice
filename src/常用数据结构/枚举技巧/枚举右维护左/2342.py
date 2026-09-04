class Solution:
    def maximumSum(self, nums: list[int]) -> int:
        # 要求ni + nj max -> ni尽量大, nj尽量大 -> 每数位和维护前缀最大值
        prefix_max, ans = {}, -1  # k:数位和, v:最大值
        for num in nums:
            digit_sum = sum(int(c) for c in str(num))
            premax = prefix_max.get(digit_sum, 0)
            if premax != 0:
                ans = max(ans, premax + num)
            prefix_max[digit_sum] = max(premax, num)
        return ans
