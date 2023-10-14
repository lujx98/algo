from typing import List

from passlib import *


class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[
        bool]:
        g = [[] for _ in range(numCourses)]
        isPre = [[False] * numCourses for _ in range(numCourses)]

        indegrees = [0] * numCourses
        for pre in prerequisites:
            indegrees[pre[0]] += 1
            g[pre[1]].append(pre[0])

        q = []
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                q.append(i)

        while len(q) is not 0:
            cur = q.pop()
            for ne in g[cur]:

                isPre[cur][ne] = True
                for i in range(numCourses):
                    isPre[i][ne] = isPre[i][ne] or isPre[i][cur]
                    pass
                indegrees[ne]-=1
                if not indegrees[ne]:
                    q.append(ne)

        res = []
        for query in queries:
            res.append(isPre[query[0]][query[1]])
        return res


Solution().checkIfPrerequisite(1, None, None)
