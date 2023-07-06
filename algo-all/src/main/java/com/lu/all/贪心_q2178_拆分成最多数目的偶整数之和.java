package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-07-06
 */
public class 贪心_q2178_拆分成最多数目的偶整数之和 {

    @Test
    public void test() {
        System.out.println(maximumEvenSplit(2));
    }

    private final List<Long> res = new ArrayList<>();
    private long finalSum;

    public List<Long> maximumEvenSplit(long finalSum) {
        this.finalSum = finalSum;
        if (finalSum % 2 != 0) {
            return Collections.emptyList();
        }

        for (long i = 1; i <= finalSum / 2; i++) {
            long dfs = dfs(0, 2 * i);
            if (dfs == finalSum) {
                return res;
            }
        }
        return Collections.emptyList();
    }

    private long dfs(long count, long cur) {
        res.add(cur);
        count += cur;
        if (count == finalSum) {
            return finalSum;
        } else if (count > finalSum) {
            res.remove(res.size() - 1);
            return -1L;
        }

        for (long i = cur + 2; i <= finalSum - count; i += 2) {
            long dfs = dfs(count, i);
            if (dfs == finalSum) {
                return finalSum;
            }
        }
        res.remove(res.size() - 1);
        return -1L;
    }

}
