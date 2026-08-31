class CombinationIterator:
    # 将输入的str拆分成若干个不同的长int的子串, 然后按字典序升序排序
    #     由于str本身就是字典序升序排列的, 因此捕获顺序就是字典序升序
    # 然后维护一个索引, 表示目前迭代指针的位置
    def __init__(self, characters: str, combinationLength: int):
        # "有序"且"字符唯一"的字符串 characters
        # 一个数字 combinationLength
        self.lst = []  # 注意实例变量要定义在init函数内; 函数外的是类变量, 所有实例共享
        self.index = 0
        path, n = [], len(characters)

        def back_trace(start: int) -> None:
            size = len(path)
            if size == combinationLength:
                self.lst.append("".join(path))

            # 候选字符索引为[start : n-1], 还有n-start个; 空缺位置为length - size
            if n - start < combinationLength - size:
                return

            for choice in range(start, n):
                path.append(characters[choice])
                back_trace(choice + 1)
                path.pop()

        back_trace(0)

    def next(self) -> str:
        # 按"字典序"升序返回长度为 combinationLength 的下一个字母组合
        ans = self.lst[self.index]
        self.index += 1
        return ans

    def hasNext(self) -> bool:
        # 只有存在长度为 combinationLength 的下一个字母组合时，才返回 true
        return self.index < len(self.lst)


# Your CombinationIterator object will be instantiated and called as such:
# obj = CombinationIterator(characters, combinationLength)
# param_1 = obj.next()
# param_2 = obj.hasNext()
