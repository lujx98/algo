package com.lu.all;

/**
 * @author sheldon
 * @date 2023-03-05
 */
public class 位运算_q982 {

    public int countTriplets(int[] nums) {
        int[] count = new int[1 << 16];
        for (int num : nums) {
            for (int i : nums) {
                count[num & i]++;
            }
        }

        int res = 0;
        for (int num : nums) {
            for (int i = 0; i < (1 << 16); i++) {
                if ((num & i) == 0) {
                    res += count[i];
                }
            }
        }
        return res;
    }

}
