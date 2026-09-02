class Solution:
    def exist(self, board: list[list[str]], word: str) -> bool:
        # 同1219
        n, m, len_word = len(board), len(board[0]), len(word)
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]

        def dfs(i, j, index) -> bool:
            # board[i][j], 寻找word[index]
            if index == len_word:
                return True

            if i < 0 or i >= n or j < 0 or j >= m or board[i][j] != word[index]:
                return False

            char = board[i][j]
            board[i][j] = ""
            for dir in dirs:
                if dfs(i + dir[0], j + dir[1], index + 1):
                    return True

            board[i][j] = char
            return False

        for i in range(n):
            for j in range(m):
                if dfs(i, j, 0):
                    return True
        return False
