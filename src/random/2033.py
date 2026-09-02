class Solution:
    def minOperations(self, grid: list[list[int]], x: int) -> int:
        # 如果所有元素 % x的结果不相同, 直接返回-1
        lst = []
        for l in grid:
            lst.extend(l)

        lst.sort()
        mod, mid = lst[0] % x, lst[len(lst) // 2]
        ans = 0
        for num in lst:
            if num % x != mod:
                return -1
            ans += abs(num - mid) // x
        return ans


# 中位数贪心: 最小距离和定律, 对于数组[ai], 要求找到数x, 使得sum(abs(x - ai))最小, 此时x是[ai]的中位数
#   证明: 假设[ai]升序排列
#   对于(a0, a_(n-1))两个数的距离和而言, 如果x < a0或 x > a_n-1, 当x向[a0, a_n-1]内部靠近时, 距离和减小
#   当x在内部时, 距离和不变, 等于a_n-1 - a_0
#   因此, 问题规模减小为distance_sum = distance_min([a1 : a_n-2]) + (a_n-1 - a_0)
#   递归到最后, x是中位数; 如果n是偶数, 可以取中间两个数之间的任意值
