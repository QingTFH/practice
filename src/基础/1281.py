class Solution:
    def subtractProductAndSum(self, n):
        """
        :type n: int
        :rtype: int
        """
        mult = 1
        sum = 0
        while n > 0:
            c = n % 10
            n /= 10
            mult *= c
            sum += c
        return mult - sum
