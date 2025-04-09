package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author sheldon
 * @date 2025-04-09
 */
public class q49 {

    @Test
    public void test(){

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        String[] clone = strs.clone();
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            strs[i] = new String(chars);
        }

        for (int i = 0; i < strs.length; i++) {
            if (map.containsKey(strs[i])){
                map.get(strs[i]).add(clone[i]);
            }else {
                List<String> objects = new ArrayList<>();
                objects.add(clone[i]);
                map.put(strs[i],objects);
            }
        }

        return new ArrayList<>(map.values());
    }

}
