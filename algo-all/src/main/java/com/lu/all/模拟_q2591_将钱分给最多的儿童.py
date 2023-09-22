class Solution:
    def distMoney(self, money: int, children: int) -> int:
        if money < children:
            return -1
        upper = 31
        res = 0
        for i in range(1, upper):
            if i == children - 1 and money - 8 * (children - 1) == 4:
                continue
            if i == children and money > 8 * children:
                continue
            if money - i * 8 < children - i:
                return res
            res = max(res, i)
        return res


print(Solution().distMoney(16, 2))
