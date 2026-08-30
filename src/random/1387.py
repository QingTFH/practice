class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        ## 1. 计算出[lo, hi]之间所有数的权重, 存入lst[[weight, value]]
        lst = []

        def getWeight(num: int) -> int:
            step = 0
            while num > 1:
                step += 1
                if num % 2 == 0:
                    num //= 2
                else:
                    num = num * 3 + 1
            return step

        for num in range(lo, hi + 1):
            lst.append([getWeight(num), num])

        ## 2. 将lst按照weight升序排序, 相同时value升序排序, 获得第k个value
        return sorted(lst)[k - 1][1]


class Solution2:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        ## 在计算权重的时候, 会遇到相同的数值, 可以使用记忆化搜索
        ## dfs(num) = dfs(num // 2) + 1 或 dfs(3 * num + 1) + 1
        dct = {}

        def getWeight(num: int) -> int:
            if num == 1:
                return 0
            if num in dct:
                return dct[num]

            if num % 2 == 0:
                r = getWeight(num // 2) + 1
            else:
                r = getWeight(num * 3 + 1) + 1

            dct[num] = r
            return r

        lst = []
        for num in range(lo, hi + 1):
            lst.append([getWeight(num), num])

        return sorted(lst)[k - 1][1]


## 对于这种记忆化搜索的行为, py内置了 "@cache" 操作
from functools import cache


class Solution3:
    def getKth(self, lo: int, hi: int, k: int) -> int:

        @cache
        def getWeight(num: int) -> int:
            if num == 1:
                return 0
            if num % 2 == 0:
                return getWeight(num // 2) + 1
            ## (num * 3 + 1)一定是偶数, 可以直接合并两步操作
            return getWeight((num * 3 + 1) // 2) + 2

        ## 用迭代器 + 自定比较器来排序
        return sorted(range(lo, hi + 1), key=getWeight)[k - 1]
