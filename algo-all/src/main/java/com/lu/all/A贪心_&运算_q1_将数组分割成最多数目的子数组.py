from typing import List


class Solution:
    def maxSubarrays(self, nums: List[int]) -> int:
        res = 0
        left = 0
        while left < len(nums):
            curAnd = nums[left]
            right = left + 1
            while right < len(nums) and curAnd != 0:
                curAnd = curAnd & nums[right]
                right += 1
            if curAnd == 0:
                res += 1
            left = right
        return max(res, 0)


print(Solution().maxSubarrays([0, 8, 0, 0, 0, 23]))
