class Solution:
    def findEvenNumbers(self, digits: list[int]) -> list[int]:
        # 取digits中的任意三个数, 组合成一个不含前导0的偶数
        # 枚举"这一位选谁", index = 0不能是0, index = 2不能是奇数
        ans = []
        cnt = [0] * 10  # 统计digits中0~9的个数
        for x in digits:
            cnt[x] += 1

        def dfs(index, pre_Num):
            # 枚举path[index]该选谁
            if index == 3:
                ans.append(pre_Num)
                return

            for digit, left_digit in enumerate(cnt):
                # 对于这条分支, 还有left_digit个digit可以选
                # 这样枚举不会有重复情况
                if (index == 0 and digit == 0) or (index == 2 and digit % 2 == 1) or left_digit == 0:
                    continue

                cnt[digit] -= 1
                dfs(index + 1, pre_Num * 10 + digit)
                cnt[digit] += 1

        dfs(0, 0)
        return ans  # 由于是从小到大枚举, 因此不需要排序
