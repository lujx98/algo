package com.lu.contest;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class c2 {

    @Test
    public void test() {
        System.out.println(isReachableAtTime(1, 1, 2, 1, 2));
    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) {
            return t > 1||t==0;
        }
        int dx = Math.abs(fx - sx);
        int dy = Math.abs(fy - sy);
        int minNeed = Math.min(dx, dy);
        minNeed += Math.max(dx, dy) - Math.min(dx, dy);
        int maxNeeed = (dx + dy);
        maxNeeed = Math.max(maxNeeed, t);

        if (t >= minNeed && t <= maxNeeed) {
            return true;
        }

        if (t > maxNeeed) {
            for (int i = minNeed; i <= maxNeeed; i++) {
                if (t - i < 0) {
                    break;
                }
                if ((t - i) > 1) {
                    return true;
                }
            }
        }

        return false;
    }

}
