from typing import List


class Solution:
    def countWays(self, nums: List[int]) -> int:
        nums.sort()
        res = 1 if nums[0] > 0 else 0
        for i in range(len(nums) - 1):
            if nums[i] < i + 1 and nums[i + 1] > i + 1:
                res += 1
        if nums[-1] < len(nums):
            res += 1
        return res


print(Solution().countWays([6, 0, 3, 3, 6, 7, 2, 7]))
