package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-08-27
 */
public class 排序_双指针_q56_合并区间 {

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(merge(ArrayUtils.makeIntArraysByString("[[2,3],[4,5],[6,7],[8,9],[1,10]]"))));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        int left = 0, right = 0;
        for (; right < intervals.length; right++) {
            int max = intervals[right][1];
            left = right;
            while (right < intervals.length - 1 && intervals[right + 1][0] <= max) {
                right++;
                max = Math.max(max, intervals[right][1]);
            }
            res.add(new int[]{intervals[left][0], max});
        }
        return res.toArray(new int[res.size()][2]);
    }

}
