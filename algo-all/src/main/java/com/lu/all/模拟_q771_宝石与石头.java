package com.lu.all;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sheldon
 * @date 2023-07-26
 */
public class 模拟_q771_宝石与石头 {

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }

}
