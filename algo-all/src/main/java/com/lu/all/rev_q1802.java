package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-04
 */
public class rev_q1802 {

    @Test
    public void test() {
        System.out.println(maxValue(4, 2, 808835420));
    }


    public int maxValue(int n, int index, int maxSum) {
        if (n == maxSum) {
            return 1;
        }
        int res = 2;
        if (n > maxSum) {
            return res;
        }
        int countDown = getCountDown(index, n);
        int sum = n + 1;
        int accu = 1;
        while (sum <= maxSum) {
            int accuOfAccu = countDown-- > 0 ? 2 : 1;
            accu = Math.min(accu + accuOfAccu, n);
            if (sum + accu > maxSum) {
                break;
            }
            sum += accu;
            res++;
        }
        return res;
    }

    private int getCountDown(int index, int n) {
        if (index >= (n / 2)) {
            return (n - 1) - index;
        }
        return index;
    }

}
