from cmath import inf
from typing import List


class Solution:
    def minSizeSubarray(self, nums: List[int], target: int) -> int:
        targetSum = sum(nums)
        res = 0
        if targetSum < target:
            s = target // targetSum
            target = target - s * targetSum
            res += (s * len(nums))
        if target == 0:
            return res
        map = dict()
        prefix = [0] * (len(nums) + 1)
        res1 = inf
        for i in range(len(nums)):
            prefix[i + 1] = prefix[i] + nums[i]
        for index in range(len(nums)):
            curTarger = prefix[index + 1] - target
            if curTarger < 0:
                map[prefix[index + 1]] = index
                continue
            if curTarger == 0:
                res1 = min(res1, index + 1)
            if curTarger in map:
                res1 = min(res1, index - map[curTarger])
            map[prefix[index + 1]] = index

        res2 = inf
        sufSum = 0
        for i in range(len(nums) - 1, -1, -1):
            sufSum += nums[i]
            curTarger = target - sufSum
            if curTarger in map:
                res2 = min(res2, (len(nums) - i + map[curTarger] + 1))

        if res1 == inf and res2 == inf:
            return -1
        if res1 == inf and res2 != inf:
            return res2 + res
        if res1 != inf and res2 == inf:
            return res1 + res
        return res + min(res1, res2)


print(Solution().minSizeSubarray([1, 2], 72))
