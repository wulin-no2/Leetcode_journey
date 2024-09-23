# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res = 0
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.traverse(root);
        return self.res
    def traverse(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        # one layer
        leftH = self.traverse(root.left)
        rightH = self.traverse(root.right)
        self.res = max(leftH + rightH, self.res)
        return 1 + max(leftH, rightH)
        
        