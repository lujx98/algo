package com.lu.daily;

import org.junit.Test;

import java.util.*;

/**
 * @author sheldon
 * @date 2023-03-11
 */
public class 前后缀_哈希表_q面1705 {

    @Test
    public void test() {
//        System.out.println(Arrays.toString(findLongestSubarray1(new String[]{"A","1","A","A","1","1","A","A"})));
        System.out.println(Arrays.toString(findLongestSubarray1(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"})));
        System.out.println(Arrays.toString(findLongestSubarray1(new String[]{"A", "A"})));
    }

    public String[] findLongestSubarray1(String[] array) {
        int[] prefix = new int[array.length + 1];
        for (int i = 1; i <= array.length; i++) {
            if (array[i - 1].charAt(0) >= 65 && array[i - 1].charAt(0) <= 90||
                    array[i - 1].charAt(0) >= 97 && array[i - 1].charAt(0) <= 122) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i - 1] - 1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        String[] res = {};
        for (int i = 0; i <= array.length; i++) {
            Integer integer = map.get(prefix[i]);
            if (integer == null) {
                map.put(prefix[i], i);
            } else {
                    if (i - integer > res.length) {
                    res = Arrays.copyOfRange(array,integer,i);
                }
            }
        }
        return res;
    }

    public String[] findLongestSubarray(String[] array) {
        List<Integer>[] prefix = new List[array.length + 1];
        prefix[0] = Arrays.asList(0, 0);
        for (int i = 1; i <= array.length; i++) {
            List<Integer> curList = new ArrayList<>();
            List<Integer> prefix1 = prefix[i - 1];
            if (array[i - 1].charAt(0) >= 65 && array[i - 1].charAt(0) <= 90) {
                curList.add(prefix1.get(0) + 1);
                curList.add(prefix1.get(1));
            } else {
                curList.add(prefix1.get(0));
                curList.add(prefix1.get(1) + 1);
            }
            prefix[i] = curList;
        }

        boolean found = false;
        String[] res = new String[]{};
        List<Integer> tail = prefix[array.length];
        int maxLength = 0;
        int dif = tail.get(0) - tail.get(1);
        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0,0);
        for (int i = 1; i <= array.length; i++) {
            List<Integer> prefix1 = prefix[i];
            int curDif = prefix1.get(0) - prefix1.get(1);
            map.put(curDif, i);
            Integer integer = map.get(dif - curDif);
            if (integer != null) {
                found = true;
                int length = i - integer;
                if (length > maxLength) {
                    res = Arrays.copyOfRange(array, integer, i);
                }
            }
        }
        return found ? res : new String[]{};
    }

}