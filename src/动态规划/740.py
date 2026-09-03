class Solution:
    def deleteAndEarn(self, nums: list[int]) -> int:
        # 压缩成dict(k:v), k:num, v:freq
        # 按k从小到大操作, 假如我选择了k, 那我会获得k*v的分数, 与此同时删除所有kn = k-1; 假如我不选k, 进入下一个k
        # ks = [], dp[i] = [0:i)的最大值, dp[0] = 0, dp[1] = ks[0] * v
        # 如果选择了ks[i], 并且ks[i-1] = ks[i]-1, 则dp[i] = dct(ks[i])*ks[i] + dp[i - 2]
        dct = {}
        for num in nums:
            dct[num] = dct.get(num, 0) + 1

        keys = sorted(dct.keys())
        n = len(keys)
        dp = [0] * (n + 1)  # dp[i] = 索引[0: i)时, keys可以获得的最大值
        dp[1] = keys[0] * dct[keys[0]]
        for i in range(2, n + 1):
            # 对i-1进行操作, 选ornot, 如果keys[i-2] == keys[i-1] - 1, 则互斥
            if keys[i - 2] == keys[i - 1] - 1:
                dp[i] = max(keys[i - 1] * dct[keys[i - 1]] + dp[i - 2], dp[i - 1])
            else:  # 可共存, 可同时选
                dp[i] = keys[i - 1] * dct[keys[i - 1]] + dp[i - 1]
        return dp[n]
