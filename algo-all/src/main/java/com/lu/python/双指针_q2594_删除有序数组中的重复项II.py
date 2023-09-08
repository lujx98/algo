from typing import *


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        c = Counter()
        left ,right ,res = 0,0,0
        for left in range(len(nums)):
            while right<len(nums) and c[nums[right]]>=2:
                right += 1
            if(right>=len(nums)):
                break
            nums[left] = nums[right]
            c[nums[left]]+=1
            res+=1
            right +=1
        return res

print(Solution().removeDuplicates([1, 1, 1, 2, 2, 3]))