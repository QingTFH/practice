class Solution:
    def countLatticePoints(self, circles: list[list[int]]) -> int:
        # 暴力枚举: 由于r <= min(x, y), 也就是说覆盖范围一定在第一象限
        # 可以枚举第一象限中 <= xmax, ymax的点, 判断是否在圆中
        circles.sort(key=lambda c: -c[2])  # 按照半径从大到小排序
        x_max = max(c[0] + c[2] for c in circles)
        y_max = max(c[1] + c[2] for c in circles)
        ans = 0
        for i in range(x_max + 1):
            for j in range(y_max + 1):
                for c in circles:
                    if (i - c[0]) ** 2 + (j - c[1]) ** 2 <= c[2] ** 2:
                        ans += 1
                        break
        return ans
