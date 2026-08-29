class Solution:
    def toLowerCase(self, s):
        """
        :type s: str
        :rtype: str
        """
        lst = list(s)
        for i in range(len(lst)):
            if lst[i].isupper():
                lst[i] = lst[i].lower()
        return "".join(lst)
