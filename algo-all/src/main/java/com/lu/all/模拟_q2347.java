package com.lu.all;

/**
 * @author sheldon
 * @date 2023-02-20
 */
public class 模拟_q2347 {

    public String bestHand(int[] ranks, char[] suits) {
        for (int i = 1; i < suits.length; i++) {
            if (suits[i]!=suits[i-1]){
                break;
            }
            if (i == 4) {
                return "Flush";
            }
        }



        return "High Card";
    }

}
