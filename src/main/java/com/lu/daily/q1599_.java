package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-03-05
 */
public class q1599_ {

    @Test
    public void test() {
        System.out.println(minOperationsMaxProfit(new int[]{5, 0, 0, 0, 0, 30}, 5, 5));
    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (boardingCost * 4 - runningCost < 0) {
            return -1;
        }
        int round = 0;
        int maxRound = -1;
        int maxProfit = 0;
        int profit = 0;
        int custom = 0;
        for (int i = 0; i < customers.length; i++) {
            custom += customers[i];
            int curProfit = 0;
            if (custom > 4) {
                curProfit = boardingCost * 4 - runningCost;
                custom -= 4;
            } else {
                curProfit = boardingCost * custom - runningCost;
                custom = 0;
            }
            profit += curProfit;
            round++;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        int extraRound = 0;
        int maxExtraRound = 0;
        while (custom != 0) {
            int curProfit = 0;
            if (custom > 4) {
                curProfit = boardingCost * 4 - runningCost;
                custom -= 4;
            } else {
                curProfit = boardingCost * custom - runningCost;
                custom = 0;
            }
            profit += curProfit;
            extraRound++;
            if (profit > maxProfit) {
                maxExtraRound = extraRound;
                maxProfit = profit;
            }
        }
        return profit > 0 ? round + maxExtraRound : -1;
    }

}