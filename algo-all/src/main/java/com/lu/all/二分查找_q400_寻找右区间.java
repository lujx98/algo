package com.lu.all;

import com.lu.utils.ArraysUtils;
import org.junit.Test;

import javax.xml.bind.annotation.XmlID;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sheldon
 * @date 2023-06-13
 */
public class 二分查找_q400_寻找右区间 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(findRightInterval(ArraysUtils.makeIntArraysByString("[[1,4],[2,3],[3,4]]"))));
    }

    public int[] findRightInterval(int[][] intervals) {
        int[][] temp = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            temp[i][1] = i;
            temp[i][0] = intervals[i][0];
        }
        Arrays.sort(temp, Comparator.comparingInt(a -> a[0]));
        int[] res = new int[intervals.length];
        for (int i = 0; i < res.length; i++) {
            int left = 0, right = res.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (temp[mid][0] >= intervals[i][1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left < res.length) {
                int i1 = temp[left][1];
                if (intervals[i1][0] >= intervals[i][1]) {
                    res[i] = i1;
                } else {
                    res[i] = -1;
                }
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

}
