package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sheldon
 * @date 2023-03-03
 */
public class q1487_1 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(getFolderNames(new String[]{"wano","wano","wano","wano"})));
    }

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String curString = names[i];
            if (map.containsKey(curString)) {
                int index = map.get(curString);
                while (map.containsKey(curString + "(" + index + ")")) {
                    index++;
                }
                String s = curString + "(" + index + ")";
                names[i] = s;
                map.put(curString, index);
                map.put(s, 1);
            } else {
                map.put(curString, 1);
                map.put(names[i], 1);
            }
        }
        return names;
    }

}
