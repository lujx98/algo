from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        right, left, res = 0, 0, 0
        for left in range(len(nums)):

            while right < len(nums) and nums[right] == val:
                right += 1
            if right >= len(nums):
                break
            nums[left] = nums[right]
            right += 1
            res += 1
        return res


print(Solution().removeElement([0, 1, 2, 2, 3, 0, 4, 2], 2))
