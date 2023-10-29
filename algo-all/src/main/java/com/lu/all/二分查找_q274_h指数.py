from typing import List


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        def check(mid: int) -> bool:
            nonlocal citations
            count = 0
            for i in citations:
                if i >= mid:
                    count += 1
            return count >= mid

        left, right = 0, len(citations)
        while left < right:
            mid = (left + right + 1) // 2
            if check(mid):
                left = mid
            else:
                right = mid - 1
        return left

print(Solution().hIndex([1, 3, 1]))
