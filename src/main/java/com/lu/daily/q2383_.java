package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-03-13
 */
public class q2383_ {

    @Test
    public void test() {
        System.out.println(minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int engCount = 0;
        int expHour = 0;
        for (int i = 0; i < energy.length; i++) {
            if (initialEnergy <= energy[i]) {
                int tmpE = energy[i] - initialEnergy + 1;
                engCount += tmpE;
                initialEnergy += tmpE;
            }
            if (initialExperience <= experience[i]) {
                int tmp = experience[i] - initialExperience + 1;
                expHour += tmp;
                initialExperience += tmp;
            }
            initialExperience += experience[i];
            initialEnergy -= energy[i];
        }
        return engCount + expHour;
    }

}
