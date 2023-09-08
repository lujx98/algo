from typing import *

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        maxDepth = 0
        res = TreeNode()
        def dfs(root:TreeNode,depth:int) -> int:
            nonlocal maxDepth , res;
            if root is None:
                maxDepth = max(depth,maxDepth)
                return depth    
            left_max_depth = dfs(root.left,depth+1)
            right_max_depth = dfs(root.right,depth+1)
            if left_max_depth==right_max_depth==maxDepth:
                res =  root;
            return max(left_max_depth,right_max_depth)
        dfs(root,0)
        return res
