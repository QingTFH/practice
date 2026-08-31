class Solution:
    def minTime(self, time: list[int], m: int) -> int:
        # 将time分成m段, 每一段中有一个元素可以被认定为0, "每段的和"的最大值为T, 求可能的最小的T
        if len(time) <= m:  # 如果len <= m, 每段都只有一个数字, 且都可以被认定为0, 和都为0, T = 0
            return 0
        return None

    # 二分查找, 跳过
