class Solution:
    def transpose(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        # 遍历(i, j)并放入(j, i)
        # 注意从n * m变成了m * n
        result = []  # new ArrayList<>()
        n, m = len(matrix), len(matrix[0])

        for i in range(m):
            result.append([])
            for j in range(n):
                result[i].append(matrix[j][i])

        return result
