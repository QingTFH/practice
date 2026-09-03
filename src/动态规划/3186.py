class Solution:
    def maximumTotalDamage(self, power: list[int]) -> int:
        # 740变种, diff变成2, k = power[i], v = freq
        # dp[index] = k ∈ [0: index - 2]的最大值;
        # 如果最后一步选择了index - 2, 那么k - 1和 k - 2都不能选, 要检查index - 3, index - 4处
        # 如果不互斥, 直接相加即可; 否则压缩问题
        dct = {}
        for num in power:
            dct[num] = dct.get(num, 0) + 1

        keys = sorted(dct.keys())
        n = len(keys)
        dp = [0] * (n + 2)
        dp[2] = keys[0] * dct[keys[0]]

        for i_key in range(1, n):  # index(dp) = index(keys) + 2
            # 本次要判断的是dp[i_dp], 也就是选ornot keys[i_keys]
            i_dp = i_key + 2
            dp_pre = dp[i_dp - 1]  # 被约束到哪一个dp
            if keys[i_key - 1] == keys[i_key] - 1 and keys[i_key - 2] == keys[i_key] - 2:
                dp_pre = dp[i_dp - 3]
            elif keys[i_key - 1] == keys[i_key] - 2 or keys[i_key - 1] == keys[i_key] - 1:
                dp_pre = dp[i_dp - 2]

            dp[i_dp] = max(dp[i_dp - 1], dp_pre + keys[i_key] * dct[keys[i_key]])

        return dp[n + 1]
