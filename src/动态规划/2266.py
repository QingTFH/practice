from functools import cache


class Solution:
    def countTexts(self, pressedKeys: str) -> int:
        # 先压缩pressedKeys -> k, v, k = 字符, v = 连续次数
        # 统计每个k-v所能代表的方案数, 最后相乘即为答案
        # 如何确定k-v所能组成的方案数呢？假设是"22", 可能是2 + 2 -> aa, 也可能是22 -> b, 本质是枚举间隔的位置
        #   假设长度为len, 可以剥离1~3(或4)个字母, 也就是dfs(len) = sum(dfs(len - i) for i in range(1, 4/5))
        #   本质爬楼梯翻版, 只是每次可以爬1, 2, 3(, 4)步; dfs(1) = 0 = dfs(0)
        lst, mod, i = [], int(1e9 + 7), 0  # 需注意1e9+7是float形变量, 大数字下会有精度缺失的问题, 要转int
        while i < len(pressedKeys):
            c = pressedKeys[i]
            cnt = 1
            while i + 1 < len(pressedKeys) and pressedKeys[i + 1] == c:
                i += 1
                cnt += 1
            lst.append((c, cnt))  # 字符, 连续次数
            i += 1

        @cache
        def dfs(len: int, mode_four: bool) -> int:
            if len == 0:
                return 1

            end = 5 if mode_four else 4
            return sum(dfs(len - i, mode_four) for i in range(1, end) if i <= len) % mod

        ans = 1
        for ch, cnt in lst:
            ans *= dfs(cnt, ch == "7" or ch == "9") % mod

        return ans % mod
