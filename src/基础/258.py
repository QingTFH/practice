class Solution:
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        while num >= 10:
            t = num % 10
            num /= 10
            num += t

        return num
