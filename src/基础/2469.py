class Solution:
    def convertTemperature(self, celsius):
        """
        :type celsius: float
        :rtype: List[float]
        """
        return [celsius + 273.15, celsius * 1.80 + 32.00]


if __name__ == "__main__":
    sol = Solution()
    print(sol.convertTemperature(20))
