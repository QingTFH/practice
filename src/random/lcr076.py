class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        return sorted(nums, key=lambda c: -c)[k - 1]


# lcr面试题, 尽量不一步调用api完成
class Solution2:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        # 手写快排
        def quick_sort(nums: list[int], left: int, right: int) -> None:
            # 左右闭区间, 对[left, right]之间的元素进行快排
            if left >= right:
                return

            # 1. 以nums[left]作为基准元素, 设定l, r = left, right双指针
            l, r = left, right
            pivot = nums[left]

            # 2. 遍历整个子数组, 右左两侧交替访问元素
            # (第一次访问的是nums[left]并让出空位, 第二次需要访问nums[right], 交替并保证两侧都有空位)
            # 当l == r时, 除了基准元素外其他元素都排序完成, 在此处插入基准元素
            while l < r:
                while l < r and nums[r] >= pivot:  # 找到右侧第一个不合法的元素, 此时l是空位
                    r -= 1
                nums[l] = nums[r]

                while l < r and nums[l] <= pivot:  # 找到左侧第一个不合法的元素, 此时r是空位
                    l += 1
                nums[r] = nums[l]

            # 跳出时, l = r = pivot应当放入的位置
            nums[r] = pivot

            # 继续对两侧子数组进行快排
            quick_sort(nums, left, r - 1)
            quick_sort(nums, r + 1, right)

        quick_sort(nums, 0, len(nums) - 1)
        return nums[-k]


# 再写一次
class Solution3:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        # 手写快排
        # 函数定义, 默认值不要定义为非常量, 因为默认值只在编译时生成, 后续不改变
        def quick_sort(nums: list[int], left=0, right=None) -> None:
            if right is None:
                right = len(nums) - 1

            # 将nums[left, right]间的部分排序
            if left >= right:
                return

            p, q = left, right
            pivot = nums[q]  # 腾出右指针的空位
            while p < q:
                while p < q and nums[p] <= pivot:
                    p += 1
                # 跳出后, nums[p]需要移到q处
                nums[q] = nums[p]

                while p < q and nums[q] > pivot:
                    q -= 1
                nums[p] = nums[q]
            nums[p] = pivot

            quick_sort(nums, left, p - 1)
            quick_sort(nums, p + 1, right)

        quick_sort(nums)
        return nums
