class Solution:
    def maximumCostSubstring(self, s: str, chars: str, vals: list[int]) -> int:
        dct = {}
        for i, ch in enumerate(chars):
            dct[ch] = vals[i]

        # dp[i] = 以s[i]为结尾的子串的最大开销
        # dp[i] = max(dp[i-1], 0) + val(s[i])
        def val(ch: str) -> int:
            return dct[ch] if ch in dct else (ord(ch) - ord("a") + 1)

        dp_pre, ans = val(s[0]), val(s[0])
        for i in range(1, len(s)):
            dp_new = max(dp_pre, 0) + val(s[i])
            ans = max(ans, dp_new)
            dp_pre = dp_new
        return max(0, ans)
