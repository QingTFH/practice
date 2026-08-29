class Solution:
    def xorOperation(self, n, start):
        """
        :type n: int
        :type start: int
        :rtype: int
        """
        # 使用循环获得nums[i], 取异或值
        result: int = 0
        for i in range(n):
            result ^= start + 2 * i

        return result
