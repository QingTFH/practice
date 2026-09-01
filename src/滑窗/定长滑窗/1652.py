class Solution:
    def decrypt(self, code: list[int], k: int) -> list[int]:
        # 对于要填写的索引index, 他的窗口是:
        #   k > 0 -> [index + 1, index + k]
        #   k < 0 -> [index - abs(k), index - 1]
        # 找到窗口左右端点l, r及窗口和win_sum后, 向右滑动即可
        # 注意l = (l+1) % len(code)
        n = len(code)
        r = k if k > 0 else n - 1
        win_sum = sum(code[r - abs(k) + 1 : r + 1])
        ans = []
        while len(ans) < n:
            ans.append(win_sum)
            r += 1
            win_sum += code[r % n]
            win_sum -= code[(r - abs(k)) % n]
        return ans
