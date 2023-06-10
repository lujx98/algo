package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-05-27
 */
public class rev_模拟_q1093_大样本统计 {

    @Test
    public void test() {
        System.out.println(sampleStats(new int[]{0, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    public double[] sampleStats(int[] count) {
        int modeCount = 0;
        double mode = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        int total = 0;
        int numberCount = Arrays.stream(count).sum();

        boolean isEven = numberCount % 2 == 0;
        int mid = numberCount / 2;
        double median = 0;
        boolean isFirstTime = true;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > modeCount) {
                modeCount = count[i];
                mode = i;
            }

            if (count[i] != 0) {
                max = Math.max(i, max);
                min = Math.min(i, min);
                total += count[i] * i;
            }

            mid -= count[i];
            if (mid == 0) {
                if (isEven) {
                    int index = i + 1;
                    while (count[index] == 0) {
                        index++;
                    }
                    median = (index + i) / 2.0;
                } else {
                    median = i;
                }
                isFirstTime = false;
            }
            if (median == 0 && isFirstTime && mid < 0) {
                median = i;
                isFirstTime = false;
            }
        }

        return new double[]{min, max, total / (double) numberCount, median, mode};
    }

}
