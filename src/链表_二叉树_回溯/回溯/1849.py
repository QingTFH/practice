class Solution:
    def splitString(self, s: str) -> bool:
        # 终止条件: 分割结束时, 恰有num == preVal - 1
        def dfs(left, preVal) -> bool:
            if left == len(s):
                return True  # 如果不合法, 到不了这里
            # 划分[left, i], 下一串为[i+1, ...]
            # 如果preVal is None, 下一个子串不能是空串
            end = len(s) - 1 if preVal is None else len(s)
            for i in range(left, end):
                num = int(s[left : i + 1])
                if preVal is not None and num >= preVal:  # 此后num再也不可能 <= preVal, 提前剪枝
                    break
                if (preVal is None or num == preVal - 1) and dfs(i + 1, num):
                    return True
            return False

        return dfs(0, None)


# "选下一个"的思路中, left,right两个参数没啥意义, 因为每次都只用到了left, 而right是循环中决定的
