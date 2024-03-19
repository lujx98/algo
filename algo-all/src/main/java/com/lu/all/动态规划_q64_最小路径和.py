from cmath import inf
from functools import cache
from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        # @cache
        def dfs(x: int, y: int) -> int:
            if x == len(grid) - 1 and y == len(grid[0]) - 1:
                return grid[x][y]
            if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]):
                return inf
            return min(dfs(x, y + 1), dfs(x + 1, y)) + grid[x][y]
        return dfs(0, 0)


print(Solution().minPathSum([[1, 3, 1], [1, 5, 1], [4, 2, 1]]))