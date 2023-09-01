package com.lu.all;

/**
 * @author sheldon
 * @date 2023-09-01
 */
public class 模拟_q2240_买钢笔和铅笔的方案数 {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int temp = 0;
        long res = 0;
        while (temp <= total) {
            res += (total - temp) / cost2 + 1;
            temp += cost1;
        }
        return res;
    }

}
