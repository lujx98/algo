class Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        n = len(s)
        res = 0
        cur_num = 0
        for index in range(n - 1, -1, -1):
            if s[index] == '1':
                if cur_num + (1 << (n - index - 1)) > k:
                    break
                cur_num += (1 << (n - index - 1))
                res += 1
        return res + s.count('0')
