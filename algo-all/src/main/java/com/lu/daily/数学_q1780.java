package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-09
 */
public class 数学_q1780 {

    @Test
    public void test(){
        System.out.println(checkPowersOfThree(91));
    }

    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if ((n % 3) == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

//    /**
//     * 动态规划不可行
//     * @param n
//     * @return
//     */
//    public boolean checkPowersOfThree(int n) {
//        List<Integer> list = new ArrayList<>();
//        int pw = 1;
//        list.add(pw);
//        while (pw <= n) {
//            pw *= 3;
//            list.add(pw);
//        }
//        boolean[] dp = new boolean[n + 1];
//        dp[0] = true;
//        dp[1] = true;
//        for (int i = 0; i < list.size(); i++) {
//
//        }
//        return dp[n];
//    }

}
