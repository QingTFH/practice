class Solution:
    def kConcatenationMaxSum(self, arr: list[int], k: int) -> int:
        # 如果数组总和presum > 0, 我们可以将presum * (k-1)设置成arr[-1], 进行dp递推
        n, mod = len(arr), int(1e9 + 7)

        def mod2zero(n: int):
            return (n % mod) if n > 0 else (n % -mod)

        dp = [0] * (n + 1)
        dp[0] = mod2zero((mod2zero(sum(x for x in arr))) * (k - 1))
        ans = dp[0]
        for i, num in enumerate(arr):
            dp[i + 1] = mod2zero(max(0, dp[i]) + num)
            ans = max(ans, dp[i + 1])
        print(dp)
        return mod2zero(max(ans, 0))

    # 错误实现, 需要更深入的分类讨论（presum>0的方向是对的, 但是结果错了）
