from collections import Counter


class Solution:
    def nextBeautifulNumber(self, n: int) -> int:
        def check(num: int) -> bool:
            map = Counter()
            while num > 0:
                map[num % 10] += 1
                num = num // 10
            for k, v in map.items():
                if k != v:
                    return False
            return True
        while 1:
            if check(n + 1):
                return n + 1
            n = n + 1