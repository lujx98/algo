package com.lu.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sheldon
 * @date 2023-01-20
 */
public class ArrayUtils {

    @Test
    public void test() {
        System.out.println(makeIntArraysByString("[[0,5],[1,2],[0,2],[0,5],[1,3]]"));
    }

    public static int[][] makeIntArraysByString(String arrayString) {
        if (arrayString.equals("[]")) {
            return new int[][]{};
        }
        //[[0,5],[1,2],[0,2],[0,5],[1,3]]
        String substring = arrayString.substring(1, arrayString.length() - 1);
        String[] split1 = substring.split("],\\[");
        String[] split2 = split1[0].split(",");
        int[][] ints1 = new int[split1.length][split2.length];
        for (int i = 0; i < split1.length; i++) {
            String subString1 = split1[i];
            if (subString1.startsWith("[")) {
                int length = subString1.length();
                subString1 = split1[i].substring(1, length);
            }
            if (subString1.endsWith("]")) {
                int length = subString1.length();
                subString1 = split1[i].substring(0, length - 1);
            }
            String[] split = subString1.split(",");
            int[] ints = new int[split.length];
            for (int j = 0; j < split.length; j++) {
                ints[j] = Integer.parseInt(split[j]);
            }
            ints1[i] = ints;
        }
        return ints1;
    }

    public static List<List<Integer>> makeIntegerListByString(String arrayString) {
        int[][] ints1 = makeIntArraysByString(arrayString);
        List<List<Integer>> objects = new ArrayList<>();
        for (int[] ints : ints1) {
            objects.add(Arrays.stream(ints).boxed().collect(Collectors.toList()));
        }
        return objects;
    }

}
