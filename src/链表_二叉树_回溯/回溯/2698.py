class Solution:
    def punishmentNumber(self, n: int) -> int:
        # 返回所有合法i的平方和
        # 合法的i: 1 <= i <= n 并且 "i * i的十进制字符串" 可以分割成若干连续子串 且子串对应的数字的和 = i
        # 枚举 + 回溯, 回溯尝试i是否合法

        # 子问题: right是一个字母, right的右侧有一个逗号, 选或不选
        # 操作: 将[left, right]划分为一个子串, 或者不划分
        #   如果划分, 将[left, right]子串进行"操作"
        #       操作: 将子串对应的数字加到ans
        #   如果不划分, 下一个问题就是考虑[left, right + 1]
        # 下一个子问题: right + 1的右侧有一个逗号, 选或不选
        # 终止情况: right不是字母, 此时判断结果
        # 入口: right是第一个字母, [left, right] = [0, 0]
        def dfs(left: int, right: int, sum: int, s: str, ans: int) -> bool:
            if right == len(s):
                return ans == sum

            if dfs(right + 1, right + 1, sum + int(s[left : right + 1]), s, ans):
                return True
            if right < len(s) - 1:  # 如果right == len - 1, 此时一定要划分, 不能走不划分的线
                return dfs(left, right + 1, sum, s, ans)
            return False

        ans = 0
        for i in range(1, n + 1):
            if dfs(0, 0, 0, str(i * i), i):
                ans += i * i
        return ans


# 没毛病，写不出来的题过一天再写就行，脑子终于清醒了
