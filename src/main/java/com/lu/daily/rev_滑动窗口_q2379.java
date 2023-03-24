package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-03-09
 */
public class rev_滑动窗口_q2379 {

    @Test
    public void test(){
        System.out.println(minimumRecolors("WBBWBWB", 2));
    }

    /**
     * 滑动窗口左右区间问题
     * 当前循环 ： 实际上只取 left 到 right -1 的元素
     * @param blocks
     * @param k
     * @return
     */
    public int minimumRecolors(String blocks, int k) {
        int l = 0, r = 0, cnt = 0;
        while (r < k) {
            cnt += blocks.charAt(r) == 'W' ? 1 : 0;
            r++;
        }
        int res = cnt;
        while (r < blocks.length()) {
            cnt += blocks.charAt(r) == 'W' ? 1 : 0;
            cnt -= blocks.charAt(l) == 'W' ? 1 : 0;
            res = Math.min(res, cnt);
            l++;
            r++;
        }
        return res;
    }

}
