class Solution:
    def maxDistance(self, arrays: list[list[int]]) -> int:
        # 从不同的数组中选取最小值和最大值, 互相相减取绝对值, 找出其中的最大值
        premin, premax, ans = arrays[0][0], arrays[0][len(arrays[0]) - 1], 0
        for i in range(1, len(arrays)):
            array = arrays[i]
            arraymin, arraymax = array[0], array[len(array) - 1]
            ans = max(ans, abs(arraymax - premin), abs(premax - arraymin))
            premin = min(arraymin, premin)
            premax = max(arraymax, premax)
        return ans
