# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        def helper(root: Optional[TreeNode],save: List[int]):
            if root is not None:
                if root.left is not None:
                    helper(root.left,save)
                if root.right is not None:
                    helper(root.right,save)
                save.append(root.val)
        save = []
        helper(root,save)
        return save