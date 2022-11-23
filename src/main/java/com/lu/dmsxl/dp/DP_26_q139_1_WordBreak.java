package com.lu.dmsxl.dp;

import java.util.List;

/**
 * @author sheldon
 * @date 2022-10-03
 */
public class DP_26_q139_1_WordBreak {

    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                int length = wordDict.get(j).length();
                if (i >= length &&
                        dp[i - length] &&
                        wordDict.get(j).equals(s.substring(i - length, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < wordDict.size(); i++) {
            for (int j = (wordDict.get(i).length()); j <= s.length(); j++) {

                if (dp[j - wordDict.get(i).length()] &&
                        wordDict.contains(s.substring(j - wordDict.get(i).length(), j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }

}
