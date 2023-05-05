package com.lu.all;

import com.lu.utils.ArraysUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-05-05
 */
public class 模拟_q2432_处理用时最长的那个任务的员工 {

    @Test
    public void test() {
        hardestWorker(100, ArraysUtils.makeIntArraysByString("[[1,1],[3,7],[2,12],[7,17]]"));
    }

    public int hardestWorker(int n, int[][] logs) {
        int res = logs[0][0];
        int max = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int max1 = logs[i][1] - logs[i - 1][1];
            if (max1 > max) {
                res = logs[i][0];
                max = max1;
            }
            if (max1 == max && logs[i][0] < res) {
                res = logs[i][0];
            }
        }
        return res;
    }

}
