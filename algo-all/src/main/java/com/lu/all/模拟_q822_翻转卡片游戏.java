package com.lu.all;

/**
 * @author sheldon
 * @date 2023-08-02
 */
public class 模拟_q822_翻转卡片游戏 {

    private int[] backs;
    private int[] fronts;

    public int flipgame(int[] fronts, int[] backs) {
        this.fronts = fronts;
        this.backs = backs;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                continue;
            }
            int min;
            int max;
            if (fronts[i] > backs[i]) {
                max = fronts[i];
                min = backs[i];
            } else {
                min = fronts[i];
                max = backs[i];
            }
            if (check(min)) {
                res = Math.min(res, min);
            }else if (check(max)){
                res = Math.min(res, max);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private boolean check(int min) {
        for (int i = 0; i < backs.length; i++) {
            if (min == backs[i] && min == fronts[i]) {
                return false;
            }
        }
        return true;
    }

}
