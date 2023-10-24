from functools import cache


class Solution:
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        @cache
        def dfs(index: int, curTarget: int) -> int:
            nonlocal n, k, target
            if target == curTarget and index == n:
                return 1
            if index == n:
                return 0
            res = 0
            for i in range(1, k + 1):
                res += dfs(index + 1, curTarget + i)
            return res
        return dfs(0, 0) % (int(1e9 + 7))
