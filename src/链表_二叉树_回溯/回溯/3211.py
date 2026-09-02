class Solution:
    def validStrings(self, n: int) -> list[str]:
        # 统计长度为n的合法二进制字符串
        # 合法: 不含相邻0
        # 选或不选型：这个位置选0 or not
        ans, path = [], ["1"] * n

        def back_trace(index):
            if index == n:
                ans.append("".join(path))
                return

            back_trace(index + 1)  # 不选0

            if index == 0 or path[index - 1] != "0":  # 可以选0
                path[index] = "0"
                back_trace(index + 1)
                path[index] = "1"  # 其实不需要恢复现场, 因为会先走1的分支再走0的分支

        back_trace(0)
        return ans
