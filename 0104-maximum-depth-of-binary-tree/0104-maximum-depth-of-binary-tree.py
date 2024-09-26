# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        return self.height(root)
    
    def height(self, node: Optional[TreeNode]) -> int:
        #base case
        if node is None:
            return 0
        left = self.height(node.left)
        right = self.height(node.right)
        return max(left, right) + 1
        