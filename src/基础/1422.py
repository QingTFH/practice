class Solution:
    def maxScore(self, s):
        """
        :type s: str
        :rtype: int
        """
        # 统计总的0,1个数, 再用前缀和思想; 两边非空, 因此先统计, 并且有边界为len - 2
        one_left = s.count("1")  # 右边还剩多少个1

        result, zero_left = 0, 0
        for i in range(len(s) - 1):
            if s[i] == "0":
                zero_left += 1
            else:
                one_left -= 1
            result = max(result, zero_left + one_left)

        return result
