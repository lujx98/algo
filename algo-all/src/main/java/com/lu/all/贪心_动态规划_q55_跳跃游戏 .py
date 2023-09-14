from functools import cache
from typing import *

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        @cache
        def dfs(index:int)-> bool:
            nonlocal nums
            if index> len(nums):
                return True
            res = False
            for i in reversed(range(1,nums[index]+1)):
                res = res or dfs(index+i)
            return res
        return dfs(0)

print(Solution().canJump([2,3,1,1,4]))