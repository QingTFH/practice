# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def nodesBetweenCriticalPoints(self, head: ListNode | None) -> list[int]:
        index, first_index, last_index, last_val = 0, 0, 0, 0
        node = head
        mn = -1  # 最小值一定出现在 now ~ last之间, 最大值一定是last ~ first
        while node.next is not None:
            if (last_val != 0) and (
                (node.val > last_val and node.val > node.next.val) or (node.val < last_val and node.val < node.next.val)
            ):
                if last_index != 0:
                    mn = min(index - last_index, mn) if mn != -1 else index - last_index
                if first_index == 0:
                    first_index = index
                last_index = index

            last_val = node.val
            index += 1
            node = node.next
        return [-1, -1] if mn == -1 else [mn, last_index - first_index]
