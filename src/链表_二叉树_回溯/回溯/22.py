# 定义prefix[i] = [0:i]中左括号的个数 - 右括号的个数, 如果存在prefix[i] < 0, 则有未匹配的右括号
# 如果用"选下一个"型的思路, 那就是选"下一个左括号的位置"
#   假设我们本次的候选索引为[start, end], 意味着[0, start - 1]是合法的, 假设其前缀和为pre
#   选定的索引为index, 那意味着[start, index - 1]都是右括号; 前缀和变成pre + 1 - (index - start), 通过pre判断能否进入该分支
# 一共可以放置n个左括号, 能够合法放置n个左括号的即为答案


class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        ans, path = [], [")"] * (2 * n)

        def back_trace(start, pre, left_n):
            # [0, start - 1]的前缀和为pre, 还有left_n个操作次数
            if left_n == 0:  # pre在进入分支前就判断了, 此时一定合法
                ans.append("".join(path))
                return

            if start == 2 * n:
                return

            for index in range(start, 2 * n):
                # 候选索引index为左括号, 那么[start, index - 1]会被设定为右括号
                # 也就是[0, start - 1]是pre, [start, index - 1]是右括号, [index]是左括号, 要判断[index - 1]处是否合法
                # pre[index - 1] = pre - (index - start)
                pre_new = pre - (index - start)  # 此时[0, index - 1]的前缀和
                if pre_new >= 0:  # 这条分支可以进入
                    path[index] = "("
                    back_trace(index + 1, pre_new + 1, left_n - 1)
                    path[index] = ")"

        back_trace(0, 0, n)
        return ans
