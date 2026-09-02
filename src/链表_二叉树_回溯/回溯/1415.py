class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        # 返回长为n的开心字符串中, 按字典序升序排列的第k个
        # 开心字符串:
        #   -> 0 <= i < s.length - 1 -> s[i] != s[i+1]
        #   -> and s[i] == 'a' or 'b' or 'c'
        # 按字典序升序构造长度为n的开心字符串，当构造了k个后直接返回
        # 构造开心字符串：暴力回溯

        # 灵茶山的解法是：注意到除了第一位, 后续的位置都不能和前面的位置相同，因此只有两个选择
        #   -> 对应二进制的0和1
        # 因此先判断第一位放置'a'的时候有几种情况num, 由n // num得到第一位应该选谁;
        # 后续的位数应该设定成二进制中的n % num，最后再将其翻译成字符串即可

        ans, path = [], [""] * n

        def back_trace(index: int) -> bool:
            # 枚举第index位放置的字母, index == 0特判, index == n结束
            if index == n:
                ans.append("".join(path))
                return len(ans) >= k

            for i in range(ord("a"), ord("d")):
                c = chr(i)
                if index > 0 and c == path[index - 1]:  # 不能放置的情况
                    continue

                path[index] = c
                if back_trace(index + 1):
                    return True
            return False

        return ans[k - 1] if back_trace(0) else ""
