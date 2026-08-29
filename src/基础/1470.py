class Solution:
    def shuffle(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: List[int]
        """
        # 0 ~ n-1, n ~ 2*n-1

        lst = []
        for i in range(n):
            lst.append(nums[i])
            lst.append(nums[i + n])
        return lst
