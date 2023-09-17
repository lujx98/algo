from heapq import *
from typing import List, Counter


class Solution:
    def minLengthAfterRemovals(self, nums: List[int]) -> int:
        c = Counter[int](nums)

        temp = []
        heapify(temp)
        for i in c.values():
            heappush(temp, -i)
        res = len(nums)
        while len(temp) > 1:
            a = -heappop(temp)
            b = -heappop(temp)
            if a is not None and b is not None:
                if a > 1:
                    heappush(temp, -(a - 1))
                if b > 1:
                    heappush(temp, -(b - 1))
                res -= 2
            else:
                break
        return res


print(Solution().minLengthAfterRemovals([1,1,1,2,4,4,4,4,4,5,6,6]))
