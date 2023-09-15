from functools import cache
from math import inf
from typing import List


class Solution:
    def minNumberOfSemesters(self, n: int, relations: List[List[int]], k: int) -> int:
        pre = [0] * n
        for i in relations:
            pre[i[1] - 1] |= (1 << i[0] - 1)
        all = (1 << n) - 1

        @cache
        def dfs(cur: int) -> int:
            if cur == 0:
                return 0
            nonlocal all, pre
            curRange = 0
            cur_learned = all ^ cur
            for curPreIndex in range(len(pre)):
                if (cur >> curPreIndex & 1 == 1) and cur_learned & pre[curPreIndex] == pre[curPreIndex]:
                    curRange |= (1 << curPreIndex)
            if curRange.bit_count() <= k:
                return dfs(cur ^ curRange) + 1

            res = inf
            index = curRange
            while index:
                if index.bit_count() <= k:
                    res = min(res, dfs(cur ^ index) + 1)
                index = (index - 1) & curRange
            return res

        return dfs(all)
