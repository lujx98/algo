package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-25
 */
public class 模拟_q6466_美丽下标对的数目 {

    @Test
    public void test() {
        System.out.println(countBeautifulPairs(new int[]{2, 5, 1, 4}));
    }

    public int countBeautifulPairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String s = String.valueOf(nums[i]);
                if (check(s.charAt(0) - '0', nums[j] % 10)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean check(int i, int j) {
        for (int k = 2; k <= i && k <= j; k++) {
            if (i % k == 0 && j % k == 0) {
                return false;
            }
        }
        return true;
    }

}
