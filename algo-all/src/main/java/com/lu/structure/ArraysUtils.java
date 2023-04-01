package com.lu.structure;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-20
 */
public class ArraysUtils {

    @Test
    public void test() {
        System.out.println(makeIntArraysByString("[[0,5],[1,2],[0,2],[0,5],[1,3]]"));
    }

    public static int[][] makeIntArraysByString(String arrayString) {
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

}
