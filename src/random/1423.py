class Solution:
    def maxScore(self, cardPoints: list[int], k: int) -> int:
        # 拿外侧的k张 = 拿内侧的n-k张,  窗口大小n-k
        sum_total, sum_part, min_part = 0, 0, float("inf")
        l, n = 0, len(cardPoints)
        for r, x in enumerate(cardPoints):
            sum_total += x
            sum_part += x
            # 窗口[l, r]
            while r - l + 1 > n - k:
                sum_part -= cardPoints[l]
                l += 1
            if r - l + 1 == n - k:
                min_part = min(min_part, sum_part)
        return sum_total - min_part
