class Solution:
    def mergeSimilarItems(
        self, items1: list[list[int]], items2: list[list[int]]
    ) -> list[list[int]]:
        # items[] = [value, weight], 要求合并相同value的weight
        dct = {}
        for value, weight in items1:  # value -> weight
            dct[value] = weight

        for value, weight in items2:
            dct[value] = dct.get(value, 0) + weight

        lst = [[k, v] for k, v in sorted(dct.items())]
        return lst


class Solution2:
    def mergeSimilarItems(
        self, items1: list[list[int]], items2: list[list[int]]
    ) -> list[list[int]]:

        ## 重写一遍, 特么的语法完全不熟练啊
        # items[i] = [value, weight], 要求合并所有相同value的weight, 使用HashMap -> dict

        # 用items1中的元素生成dct
        dct = {item[0]: item[1] for item in items1}

        # 将items2中的元素加入dct
        for value, weight in items2:
            dct[value] = dct.get(value, 0) + weight

        # 生成lst, 按value升序排列
        return [[k, v] for k, v in sorted(dct.items())]
