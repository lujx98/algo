from typing import List


class Solution:
    def checkValidGrid(self, grid: List[List[int]]) -> bool:
        map = dict()
        x, y = 0, 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                map[grid[i][j]] = str(i) + str(j)
                if grid[i][j] == 0:
                    x, y = i, j
        if x != 0 or y != 0:
            return False

        def check(x: int, y: int, nextX: int, nextY: int):
            if abs(nextX - x) == 1:
                return abs(nextY - y) == 2
            if abs(nextY - y) == 1:
                return abs(nextX - x) == 2
            return False

        def dfs(x: int, y: int) -> bool:
            nonlocal grid, map
            if grid[x][y] == len(grid) * len(grid) - 1:
                return True
            s = map[grid[x][y] + 1]
            nextX, nextY = s[0], s[1]
            return check(x, y, int(nextX), int(nextY)) and dfs(int(nextX), int(nextY))

        return dfs(x, y)
Solution().checkValidGrid([[24,11,22,17,4],[21,16,5,12,9],[6,23,10,3,18],[15,20,1,8,13],[0,7,14,19,2]])