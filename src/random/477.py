class Solution:
    def totalHammingDistance(self, nums: list[int]) -> int:
        def HammingDistance(a: int, b: int) -> int:
            # 都是int, 因此只有32位
            # 会超时
            result = 0
            for i in range(32):
                flag = 1 << i
                if a & flag != b & flag:
                    result += 1
            return result

        result = 0
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                result += HammingDistance(nums[i], nums[j])

        return result


# 查询题解后明白：不妨将问题先简化为一维(所有数字只有一位), 假如一共有a个1和b个0
# 对于1而言, 其他1的hanmmingdistance = 0, 其他0的d = 1
# 因此, 这一位上的hmd = 2ab / 2
# 将32位的hmd加起来就是答案


class Solution2:
    def totalHammingDistance(self, nums: list[int]) -> int:
        result = 0
        for i in range(32):  # 统计第i位的0, 1个数
            zero, one = 0, 0
            for num in nums:
                if num & (1 << i) == 0:
                    zero += 1
                else:
                    one += 1
            result += zero * one
        return result
