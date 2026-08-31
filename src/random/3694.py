class Solution:
    def distinctPoints(self, s: str, k: int) -> int:
        n = len(s)
        if n <= k:
            return 1

        # 要求恰好移除一个长度为k的窗口, 求剩下的部分中不同的结果; 由于总和确定, 其实是求窗口的不同和
        st = set()
        dct = {"U": [0, 1], "D": [0, -1], "L": [-1, 0], "R": [1, 0]}
        sum_x, sum_y, l = 0, 0, 0
        for r, x in enumerate(s):
            sum_x += dct[x][0]
            sum_y += dct[x][1]
            # 窗口[l, r]
            while r - l + 1 > k:
                sum_x -= dct[s[l]][0]
                sum_y -= dct[s[l]][1]
                l += 1
            if r - l + 1 == k:
                st.add((sum_x, sum_y))
        return len(st)
