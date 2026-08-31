class Solution:
    def asteroidsDestroyed(self, mass: int, asteroids: list[int]) -> bool:
        lst = sorted(asteroids)
        for num in lst:
            if mass >= num:
                mass += num
            else:
                return False
        return True
