package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-07-05
 */
public class 模拟_q2600_K件物品的最大和 {

    @Test
    public void test(){
        System.out.println(1688530910285L > System.currentTimeMillis());
    }

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
