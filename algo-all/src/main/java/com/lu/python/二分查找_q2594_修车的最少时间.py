from typing import *
from math import *

class Solution:

    def repairCars(self, ranks: List[int], cars: int) -> int:
        left ,right = 0,20
        def check(mid:int,ranks:List[int],cars:int) -> bool:
            count  = 0
            for i in range(len(ranks)):
                count+= isqrt(mid//ranks[i])
            return count >= cars
        while left < right:
            mid = (left + right)>>1
            if(check(mid,ranks,cars)):
                right = mid
            else:
                left = mid + 1 
        return left
    

print(Solution().repairCars([4,2,3,1],10))
print(Solution().repairCars([5,1,8],6))
    
