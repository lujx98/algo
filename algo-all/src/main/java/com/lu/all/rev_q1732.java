package com.lu.all;

/**
 * @author sheldon
 * @date 2022-11-19
 */
public class rev_q1732 {

    public int largestAltitude(int[] gain) {
        int res = 0;
        int altitude = 0;
        for (int i : gain) {
            altitude += i;
            res = Math.max(res, altitude);
        }
        return res;
    }

}
