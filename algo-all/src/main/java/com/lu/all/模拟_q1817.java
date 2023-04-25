package com.lu.all;

import com.lu.utils.ArraysUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-01-20
 */
public class 模拟_q1817 {

    @Test
    public void test() {
        findingUsersActiveMinutes(ArraysUtils.makeIntArraysByString("[[305589003,4136],[305589004,4139],[305589004,4141],[305589004,4137],[305589001,4139],[305589001,4139]]"),6);
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        Arrays.sort(logs, (o1, o2) -> {
            if (!(o1[0] == o2[0])) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int count = 1;
        int[] Temp = 2 >= logs.length ? null : logs[1];
        if (Temp == null || logs[0][0] != Temp[0]) {
            res[count - 1]++;
            count = 0;
        }

        for (int i = 1; i < logs.length; i++) {
            int[] next = i + 1 >= logs.length ? null : logs[i + 1];
            int[] cur = logs[i];
            int[] prev = logs[i - 1];
            //如果是当前用户最后一次操作，则初始化到数组内，并且计数归零
            if (next == null || cur[0] != next[0]) {
                if (cur[0] != prev[0] || cur[1] != prev[1]) {
                    count++;
                }
                res[count - 1]++;
                count = 0;
                continue;
            }
            //如果是当前用户第一次操作
            //如果是不是当前用户第一次操作，但操作分钟数是第一次出现
            //则++
            if (cur[0] != prev[0] || cur[1] != prev[1]) {
                count++;
            }
        }
        return res;
    }

}
