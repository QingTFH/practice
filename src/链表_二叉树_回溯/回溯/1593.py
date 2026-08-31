# "选或不选"型回溯
class Solution:
    def maxUniqueSplit(self, s: str) -> int:
        st = set()

        def dfs(left, right):
            if right == len(s):
                return len(st)

            r = 0
            if right < len(s) - 1:  # 可以不断
                r = max(r, dfs(left, right + 1))

            sp = s[left : right + 1]
            if sp not in st:  # 可以断
                st.add(sp)
                r = max(r, dfs(right + 1, right + 1))
                st.remove(sp)
            return r

        return dfs(0, 0)


# “多选一个”型回溯
class Solution2:
    def maxUniqueSplit(self, s: str) -> int:
        st = set()

        def dfs(left, right):
            if right == len(s):
                return len(st)

            r = 0
            # 尝试划分[left, i]
            for i in range(right, len(s)):
                sp = s[left : i + 1]
                if sp not in st:
                    st.add(sp)
                    r = max(r, dfs(i + 1, i + 1))
                    st.remove(sp)
            return r

        return dfs(0, 0)
