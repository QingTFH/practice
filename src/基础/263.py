class Solution:
    def isUgly(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n <= 0:
            return False

        # 如果它的质因数只有2, 3, 5, 那么剥去全部的2, 3, 5后剩下的就是1; 否则剩下的就不是1
        factors = (2, 3, 5)
        for factor in factors:
            while n % factor == 0:
                n /= factor

        return n == 1
