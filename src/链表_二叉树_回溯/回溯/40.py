class Solution:
    def combinationSum2(self, candidates: list[int], target: int) -> list[list[int]]:
        # 找出组合, 要求sum恰好等于target
        # candidates[i] > 0, 因此当sum > target时剪枝
        # candidates中有重复元素, 因此要先排序以保证"重复的数字聚集在一起"
        # "选下一个"型: 如果候选区间[start, n-1], 并且我们选择了index > start
        #   那就意味着[start, index - 1]是我们没有选择的位置
        #   如果index和index - 1是重复元素num, 就会出现两次"选择了一个num"的情况, 需要跳过
        #   也就是说, 不能选择和"已放弃"的候选元素相同的元素
        candidates.sort()
        ans, path, n = [], [], len(candidates)

        def back_trace(start, sum):
            if sum == target:
                ans.append(path.copy())
                return

            if sum > target or start == n:
                return

            for index in range(start, n):
                if index > start and candidates[index] == candidates[index - 1]:
                    continue

                path.append(candidates[index])
                back_trace(index + 1, sum + candidates[index])
                path.pop()

        back_trace(0, 0)
        return ans
