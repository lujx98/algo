package com.lu.algo.dynamic;


/**
 * @author sheldon
 * @date 2022-03-19
 */
public class q121 {
    //max(f(t-1),)
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(prices[i]-minPrice,maxProfit);
            }
        }
        return maxProfit;
    }

    public static int bestAns(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
