from cmath import inf
from typing import List


class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        suffix = [0] * len(nums)
        suffix[-1] = nums[-1]
        for i in range(len(nums) - 2, -1, -1):
            suffix[i] = max(nums[i], suffix[i + 1])

        preMax = nums[0]
        res = -inf
        for i in range(1, len(nums) - 1, 1):
            res = max(res, (preMax - nums[i]) * suffix[i + 1])
            preMax = max(preMax, nums[i])
        return max(0, res)


print(Solution().maximumTripletValue([10, 13, 6, 2]))
