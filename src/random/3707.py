class Solution:
    def scoreBalance(self, s: str) -> bool:
        # 依旧前缀和, 每次将i处的元素添加至左侧, 需要两侧子串都不为空
        # 其实空也无所谓, 一定不满足要求
        score_total = sum(ord(x) - ord("a") + 1 for x in s)
        score_left = 0
        for i in range(len(s) - 1):
            score_left += ord(s[i]) - ord("a") + 1
            if score_left * 2 == score_total:
                return True
        return False
