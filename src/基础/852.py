class Solution:
    def peakIndexInMountainArray(self, arr: list[int]) -> int:
        # 二分, 如果还在下坡说明在左边, 反之在右边
        l, r = 0, len(arr) - 2
        while l < r - 1:
            # 终止的时候, l l+1是上坡, r, r+1是下坡, 所以l+1和r是同一个位置, l = r-1
            mid = (l + r) // 2
            if arr[mid] < arr[mid + 1]:  # 还在上坡
                l = mid
            else:
                r = mid
        return r
