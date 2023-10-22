from functools import cache
from typing import List


class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        satisfaction.sort()
        @cache
        def dfs(index: int, multi: int) -> int:
            nonlocal satisfaction
            if index >= len(satisfaction):
                return 0
            return max(dfs(index + 1, multi), dfs(index + 1, multi + 1) + satisfaction[index] * multi)
        return dfs(0, 1)
