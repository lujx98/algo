from typing import List


class Solution:
    def constructProductMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        a = 1
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                a *= grid[i][j]

        res = [[0] * len(grid[0]) for i in range(len(grid))]

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                res[i][j] = ((a // grid[i][j]) % 12345)
        return res


Solution().constructProductMatrix([[1, 2], [3, 4]])
