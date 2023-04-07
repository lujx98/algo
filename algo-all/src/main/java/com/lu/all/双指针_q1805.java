package com.lu.all;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author sheldon
 * @date 2022-12-06
 */
public class 双指针_q1805 {

    @Test
    public void test() {
        System.out.println(numDifferentIntegers("u"));
    }

    public int numDifferentIntegers(String word) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            while (i < word.length() && (!Character.isDigit(word.charAt(i)) || word.charAt(i) == 48)) {
                i++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (i < word.length() && Character.isDigit(word.charAt(i))) {
                stringBuilder.append(word.charAt(i));
                i++;
            }
            if (stringBuilder.length() > 0) {
                set.add(stringBuilder.toString());
            }
        }
        return set.size();
    }


//    public int numDifferentIntegers(String word) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = word.length() - 1; i >= 0; i--) {
//            char c = word.charAt(i);
//            if (!(Character.isDigit(c))) {
//                continue;
//            }
//            int count = 1;
//            int element = 0;
//            while (c >= 48 && c <= 57) {
//                element += Character.getNumericValue(c) * count;
//                count *= 10;
//                i--;
//                if (i < 0) {
//                    break;
//                }
//                c = word.charAt(i);
//            }
//            set.add(element);
//        }
//        return set.size();
//    }

}
