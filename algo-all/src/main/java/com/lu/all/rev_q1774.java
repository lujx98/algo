package com.lu.all;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-12-04
 */
public class rev_q1774 {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int min = Arrays.stream(baseCosts).min().getAsInt();
        if (min > target) {
            return min;
        }
        boolean[] dp = new boolean[target + 1];
        //res仅仅用来寻找比target大的答案
        //如果 res表示用最便宜的基料的范围
        int res = 2 * target - min;
        for (int b : baseCosts) {
            if (b <= target) {
                dp[b] = true;
            } else {
                res = Math.min(res, b);
            }
        }

        for (int t : toppingCosts) {
            for (int count = 0; count < 2; ++count) {
                for (int i = target; i > 0; --i) {
                    //如果不加盖码前是合法的，那么更新res（加上盖码后大于target）（更新在大于target的前提下，离target最近的值）
                    if (dp[i] && i + t > target) {
                        res = Math.min(res, i + t);
                    }
                    //dp的状态转移公司  dp[i] = dp[i] | dp[i-t]  t表示盖码的遍历索引
                    if (i - t > 0) {
                        dp[i] = dp[i] | dp[i - t];
                    }
                }
            }
        }

        for (int i = 0; i <= res - target; ++i) {
            if (dp[target - i]) {
                return target - i;
            }
        }


        return res;
    }

}
