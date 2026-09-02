class Solution:
    def uniformArray(self, nums1: list[int]) -> bool:
        # n2[i] = n1[i] 或 n1[i] - n1[j]
        # 假如要求构造奇数, n1[i]为偶数, 只要存在n1[j]为奇数即可
        #                  n1[i]为奇数 -> 不变
        # 假如要求构造偶数, n1[i]为偶数 -> 不变
        #                  n1[i]为奇数, 只要存在n1[j]为奇数即可
        # 综上, 全偶数/存在奇数都可以, 那不特么就是true吗
        return True
