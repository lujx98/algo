package com.lu.dmsxl;

import java.util.Objects;

/**
 * @author sheldon
 * @date 2022-09-19
 */
public class _q169_1_MajorityElement {

    public int majorityElement(int[] nums) {
        Hill hill = new Hill();
        for (int num : nums) {
            hill.attack(num);
        }
        return hill.getCurrent();
    }

    public class Hill {
        private Integer current;
        private int number;

        public int getCurrent() {
            return current;
        }

        public void attack(int n) {
            if (current == null) {
                current = n;
                number++;
                return;
            }
            if (Objects.equals(n, current)) {
                number++;
                return ;
            }
            number--;
            if (number == 0) {
                current = null;
            }
        }
    }

}
