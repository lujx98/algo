from typing import List, Counter


class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        counter = Counter[int]()
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                counter.update({nums[i] * nums[j]})
        it = list(counter.values())
        res = 0
        for i in it:
            if i >= 2:
                cur = 1
                for i in range(i - 1, i + 1):
                    cur *= i
                res += cur * 4
        return res


print(Solution().tupleSameProduct([1, 2, 4, 5, 10]))
