class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        # 维护前缀最小值, ans = max(prices[i] - min[i])
        pre_min, ans = prices[0], 0
        for price in prices:
            pre_min = min(pre_min, price)
            ans = max(ans, price - pre_min)
        return ans
