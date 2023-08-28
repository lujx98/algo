package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-08-28
 */
public class rev_模拟_边界值讨论_q57_插入区间 {

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(insert(new int[][]{}, new int[]{5, 7})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        for (; i < intervals.length; i++) {
            int r = intervals[i][1], l = intervals[i][0];
            if (r < newInterval[0]) {
                res.add(intervals[i]);
            } else if (l > newInterval[1]) {
                break;
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], r);
            }
        }
        res.add(newInterval);
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }

}
