class Solution:
    def computeArea(self, ax1: int, ay1: int, ax2: int, ay2: int, bx1: int, by1: int, bx2: int, by2: int) -> int:
        # 模拟:
        # 两个矩形无重叠 = x坐标无重叠 或 y坐标无重叠; *x/y1是较小的, 2是较大的
        overlap = 0
        if not (ax1 > bx2 or bx1 > ax2 or ay1 > by2 or by1 > ay2):  # 有重叠部分
            overlap_x = min(ax2, bx2) - max(ax1, bx1)  # x方向上的重叠部分长度 = 两边大中的小 - 两边小中的大
            overlap_y = min(ay2, by2) - max(ay1, by1)
            overlap = overlap_x * overlap_y

        return (ay2 - ay1) * (ax2 - ax1) + (by2 - by1) * (bx2 - bx1) - overlap
