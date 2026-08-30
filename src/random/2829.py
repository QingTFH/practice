class Solution:
    def minimumSum(self, n: int, k: int) -> int:
        # 枚举小值, 如果可以加入lst则加入, 直到size = n
        st, size, sum, num = set(), 0, 0, 1
        while size < n and num < k:
            if not (k - num in st):  # 将num加入st
                st.add(num)
                size += 1
                sum += num
            num += 1
        if size < n:  # 此时一定有num = k, 还差diff = n - size个数, 并且>=k的任何数都可以选, 求[k, k + diff - 1]的和
            sum += (k + k + n - size - 1) * (n - size) // 2
        return sum
