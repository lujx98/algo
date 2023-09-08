from typing import *


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        min_len = min(len(strs[i]) for i in range(len(strs)))
        res = ""
        for i in range(min_len):
            isMatch = 1
            char = strs[0][i]
            for strIndex in range(len(strs)):
                if not char == strs[strIndex][i]:
                    isMatch = 0
                    break
            if  not isMatch:
                break
            res += char
        return res
print(Solution().longestCommonPrefix(["flower","flow","flight"]))