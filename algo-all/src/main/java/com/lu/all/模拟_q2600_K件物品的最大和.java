package com.lu.all;

/**
 * @author sheldon
 * @date 2023-07-05
 */
public class 模拟_q2600_K件物品的最大和 {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;
        if (numOnes > k) {
            return k;
        }
        k -= numOnes;
        sum += numOnes;
        if (numZeros > k) {
            return sum;
        }
        k -= numZeros;
        return sum - k;
    }

}
