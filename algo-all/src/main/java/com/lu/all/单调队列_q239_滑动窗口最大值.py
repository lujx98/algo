from collections import deque
from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        deq = deque()
        for index in range(k):
            while deq and index - deq[0][0] > k - 1:
                deq.popleft()
            while deq and deq[-1][1] < nums[index]:
                deq.pop()
            deq.append([index, nums[index]])
        res.append(deq[0][1])
        for index in range(k, len(nums)):
            while deq and index - deq[0][0] > k - 1:
                deq.popleft()
            while deq and deq[-1][1] < nums[index]:
                deq.pop()
            deq.append([index, nums[index]])
            res.append(deq[0][1])

        return res


print(Solution().maxSlidingWindow([1, 3, -1, -3, 5, 3, 6, 7], 3))