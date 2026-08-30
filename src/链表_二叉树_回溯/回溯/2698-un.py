class Solution:
    def punishmentNumber(self, n: int) -> int:
        # 返回所有合法i的平方和
        # 合法的i: 1 <= i <= n 并且 "i * i的十进制字符串" 可以分割成若干连续子串 且子串对应的数字的和 = i
        # 枚举 + 回溯, 回溯尝试i是否合法

        # py写的我好难受, 先跳过吧

        path = []

        def dfs(left: int, right: int) -> bool:
            # 此时要判断的index = right
            # 当index == len时所有划分结束, 判断是否合法
            if right == len:
                # 此时是最后一步, 判断这个路径是否是
                pass

            # 将right放入串中, 考虑此时要不要进行分割为[left, right][right + 1, ...]
            right += 1

            # 如果下一步是判定环节(right == len - 1), 那么这一步就一定要切割
            if right < len - 1 and dfs(left, right):
                return True

            # 不放入左子串, 此时切断, [left, right]为一个子串, [right + 1, ...]为下一个子串
            path.append([left, right])
            if dfs(right + 1, right):
                return True
            path.pop()
            return False

        ans = 0
        for i in range(1, n + 1):
            if dfs(i):
                ans += i * i
        return ans
