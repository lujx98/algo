from collections import deque
from math import inf
from typing import List


class Solution:
    def findMaxValueOfEquation(self, points: List[List[int]], k: int) -> int:
        q = deque()
        res = -inf
        for x, y in points:
            while q and x - q[0][0] > k:
                q.popleft()
            if q:
                res = max(res, q[0][1] + x + y)
            while q and q[-1][1] < y - x:
                q.pop()
            q.append((x, (y - x)))
        return res
