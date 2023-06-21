package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-20
 */
public class 模拟_q2739_总行驶距离主油箱副油箱 {

    @Test
    public void test() {
        System.out.println(distanceTraveled(29, 7));
    }

    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        int cur = mainTank;
        while (true) {
            if (cur < 5) {
                res += cur * 10;
                break;
            }
            int cur1 = cur / 5;
            int addGas = Math.min(cur1, additionalTank);
            additionalTank -= addGas;
            cur += addGas;
            cur -= cur1 * 5;
            res += cur1 * 5 * 10;
        }
        return res;
    }

}
