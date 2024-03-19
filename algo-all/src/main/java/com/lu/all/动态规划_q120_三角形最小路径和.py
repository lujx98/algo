from cmath import inf
from functools import cache
from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        @cache
        def dfs(layer: int, index: int) -> int:
            if layer == len(triangle) - 1:
                return triangle[layer][index]
            if index < 0 or index >= len(triangle[layer]):
                return inf
            m1 = dfs(layer + 1, index + 1) + triangle[layer][index]
            e = dfs(layer + 1, index) + triangle[layer][index]
            return min(m1, e)
        return dfs(0, 0)


print(Solution().minimumTotal([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]))
