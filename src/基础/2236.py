# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def checkTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        # Optional[Class] 说明可以输入Class类的变量, 也可以是None, 等价于 Class | None
        return root.val == root.left.val + root.right.val
