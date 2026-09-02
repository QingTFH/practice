class Solution:
    def subsetsWithDup(self, nums: list[int]) -> list[list[int]]:
        # "选下一个"型回溯, 存入st时转str/tuple
        st = set()
        ans, path, n = [], [], len(nums)
        nums.sort()  # 让小数一定出现在大数前, 让重复的数字聚集在一起

        def back_trace(start: int) -> None:
            # [start, n - 1]是可选的
            if tuple(path) in st:
                return

            st.add(tuple(path))
            ans.append(path.copy())

            for index in range(start, n):
                path.append(nums[index])
                back_trace(index + 1)
                path.pop()

        back_trace(0)
        return ans
