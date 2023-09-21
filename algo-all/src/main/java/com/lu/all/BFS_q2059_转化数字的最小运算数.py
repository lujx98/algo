from collections import deque
from typing import List


class Solution:
    def minimumOperations(self, nums: List[int], start: int, goal: int) -> int:
        q = deque()
        q.append(start)
        res = 0
        visited = [False] * 1001
        while len(q) != 0:
            res += 1
            for i in range(len(q)):
                cur = q.popleft()
                for incur in nums:
                    for i in [cur + incur, cur - incur, cur ^ incur]:
                        if i == goal:
                            return res
                        if 0 <= i <= 1000 and not visited[i]:
                            visited[i] = True
                            q.append(i)
        return -1


print(Solution().minimumOperations([3,5,7], 0, -4))
