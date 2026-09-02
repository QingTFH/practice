class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> list[int]:
        # 返回所有长度为n的合法int类数字
        # 合法：每两位上差的绝对值为k，并且没有前导0 -> index = 0要特判
        ans, path = [], [0] * n

        def back_trace(index):
            if index == n:
                ans.append(int("".join(str(x) for x in path)))  # 每一位转str再拼接, 最后转int
                return

            start = 0 if index > 0 else 1
            for num in range(start, 9 + 1):
                if index == 0 or abs(num - path[index - 1]) == k:  # 可以选
                    path[index] = num
                    back_trace(index + 1)

        back_trace(0)
        return ans
