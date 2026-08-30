class Solution:
    def recoverOrder(self, order: list[int], friends: list[int]) -> list[int]:
        st = set(friends)
        return [x for x in order if x in st]
