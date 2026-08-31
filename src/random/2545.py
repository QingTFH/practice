class Solution:
    def sortTheStudents(self, score: list[list[int]], k: int) -> list[list[int]]:
        # 以score[*][k]为关键词, 降序排列score
        return sorted(score, key=lambda sc: -sc[k])
