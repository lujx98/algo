from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        left, right,res = 0, 0, 0
        for left in range(len(nums)):
            while right < len(nums) - 1 and nums[right] == nums[right + 1]:
                right += 1
            if right >= len(nums):
                break
            nums[left] = nums[right]
            res +=1
            right += 1
        return res


print(Solution().removeDuplicates([1]))
