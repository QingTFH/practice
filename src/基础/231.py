class Solution:
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        # 2的幂次 <-> 二进制中只有一个1
        return n > 0 and n & (n - 1) == 0


if __name__ == "__main__":
    sol = Solution()
    print(sol.isPowerOfTwo(2))
    print(sol.isPowerOfTwo(6))
