package com.lu.all;

import com.lu.utils.IOUtils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-08-22
 */
public class rev_二分查找_差分数组_前缀和_q2528_最大化城市的最小供电站数目 {

    @Test
    public void test() {
        int[] input = IOUtils.input();
        System.out.println(maxPower(input, 18088, 336238182));
    }

    public long maxPower(int[] stations, int r, int k) {
        long[] prefix = new long[stations.length + 1];
        for (int i = 1; i <= stations.length; i++) {
            prefix[i] = prefix[i - 1] + stations[i - 1];
        }
        long[] temp = new long[stations.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = prefix[Math.min(stations.length, i + r + 1)] - prefix[Math.max(i - r, 0)];
        }

        long[] diff = new long[stations.length + 1];
        diff[0] = temp[0];
        long max = temp[0];
        for (int i = 1; i < stations.length; i++) {
            max = Math.max(max, temp[i]);
            diff[i] = temp[i] - temp[i - 1];
        }

        long left = 0, right = max + ((r * 2L + 1) / stations.length);
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (check(mid, Arrays.copyOf(diff, diff.length), k, r)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (check(left, Arrays.copyOf(diff, diff.length), k, r)) {
            return left;
        }
        return left - 1;
    }

    private boolean check(long mid, long[] diff, int k, int r) {
        long sum = 0;
        for (int i = 0; i < diff.length - 1; i++) {
            sum += diff[i];
            if (sum >= mid) {
                continue;
            }
            long need = mid - sum;
            if (k < need) {
                return false;
            }
            if (i + 2 * r + 1 < diff.length) {
                diff[i + 2 * r + 1] -= need;
            }
            k -= need;
            diff[i] += need;
            sum += need;
        }
        return true;
    }

    public long maxPower1(int[] stations, int r, int k) {
        int n = stations.length;
        long[] sum = new long[n + 1]; // 前缀和
        for (int i = 0; i < n; ++i)
            sum[i + 1] = sum[i] + stations[i];
        long mn = Long.MAX_VALUE;
        long[] power = new long[n]; // 电量
        for (int i = 0; i < n; ++i) {
            power[i] = sum[Math.min(i + r + 1, n)] - sum[Math.max(i - r, 0)];
            mn = Math.min(mn, power[i]);
        }

        long left = mn, right = mn + k + 1; // 开区间写法
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (check(mid, power, n, r, k)) left = mid;
            else right = mid;
        }
        return left;
    }

    private boolean check(long minPower, long[] power, int n, int r, int k) {
        long[] diff = new long[n + 1]; // 差分数组
        long sumD = 0, need = 0;
        for (int i = 0; i < n; ++i) {
            sumD += diff[i]; // 累加差分值
            long m = minPower - power[i] - sumD;
            if (m > 0) { // 需要 m 个供电站
                need += m;
                if (need > k) return false; // 提前退出这样快一些
                sumD += m; // 差分更新
                if (i + r * 2 + 1 < n) diff[i + r * 2 + 1] -= m; // 差分更新
            }
        }
        return true;
    }


}
