from typing import List


class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        def check(mid: int) -> bool:
            nonlocal nums
            for index in range(mid):
                if nums[index] * 2 > nums[len(nums) - mid + index]:
                    return False
            return True

        nums.sort()
        left, right = 0, len(nums) // 2
        while left < right:
            mid = (left + right + 1) // 2
            if check(mid):
                left = mid
            else:
                right = mid - 1
        return left * 2
