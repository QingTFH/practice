class Solution:
    def expressiveWords(self, s: str, words: list[str]) -> int:
        # 每个str都可以压缩成一个字母组列表[[word, num]], 包括s
        def str2list(s: str) -> list[tuple[str, int]]:
            ans = []
            word, num = 0, 0  # 当前的组
            for c in s:
                if c == word:
                    num += 1
                else:
                    if num > 0:
                        ans.append((word, num))
                    word = c
                    num = 1
            if num > 0:
                ans.append((word, num))
            return ans

        # 对于s_list和word_list, 要求每一个位置的word都一样, 并且要么s_list[index][num] >= 3, 要么二者num相等
        def list_legal(s: list[tuple[str, int]], word: list[tuple[str, int]]) -> bool:
            if len(s) != len(word):
                return False
            for i in range(len(s)):
                s_letter, s_num = s[i]
                letter, num = word[i]
                if not (s_letter == letter and (s_num == num or (s_num > num and s_num >= 3))):
                    return False
            return True

        s_list, ans = str2list(s), 0
        for word in words:
            if list_legal(s_list, str2list(word)):
                ans += 1
        return ans
