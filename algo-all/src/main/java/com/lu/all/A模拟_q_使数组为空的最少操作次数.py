from typing import List


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        map = dict()
        for i in nums:
            if i in map:
                map[i] += 1
            else:
                map[i] = 1
        collection = list(map.values())
        res = 0
        for i in collection:
            if i < 2:
                return -1
            res += (i + 2) // 3
        return res


print(Solution().minOperations([2, 3, 3, 2, 2, 4, 2, 3, 4]))
