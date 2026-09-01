# 越短越合法: 越短的子串, 越可能更多的出现, 不同字母数目也越小, 因此不用使用maxSize
class Solution:
    def maxFreq(self, s: str, maxLetters: int, minSize: int, maxSize: int) -> int:
        dct = {}  # 字母 -> 次数
        ans = {}  # {k:v}是字典, {a}是集合; {}默认为字典, 初始化集合使用set()

        for r in range(len(s)):
            dct[s[r]] = dct.get(s[r], 0) + 1
            # 当前窗口[r - minSize + 1, r]
            l = r - minSize + 1
            if l < 0:
                continue

            if len(dct) <= maxLetters:
                win_str = s[l : r + 1]
                ans[win_str] = ans.get(win_str, 0) + 1

            if dct[s[l]] == 1:
                dct.pop(s[l])
            else:
                dct[s[l]] = dct[s[l]] - 1

        if not ans:  # 相当于: if not bool(ans), bool(a)当ans为"0/None/空集合"时返回False
            return 0
        return max(ans.values())
