class Solution:
    def findMaxForm(self, strs: list[str], m: int, n: int) -> int:
        # 回溯 + 状态压缩
        # 会TLE, 需要学习更优秀的算法, 跳过
        nums = []
        for i in range(len(strs)):
            z, o = 0, 0
            for c in strs[i]:
                if c == "1":
                    o += 1
                else:
                    z += 1
            nums.append[z, o]
        # nums[i] = [zero, one] = strs[i]右多少个0, 多少个1

        # 递归方法: 选 or not ->
        def dfs(index: int, zero_left: int, one_left: int, length: int) -> int:
            if index == len(nums) or (zero_left == 0 and one_left == 0):
                return length

            result = dfs(index + 1, zero_left, one_left, length)  # 不选

            if zero_left >= nums[index][0] and one_left >= nums[index][1]:  # 可以选
                result = max(
                    result,
                    dfs(
                        index + 1,
                        zero_left - nums[index][0],
                        one_left - nums[index][1],
                        length + 1,
                    ),
                )
            return result

        return dfs(0, m, n, 0)
